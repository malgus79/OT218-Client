package com.melvin.ongandroid.view.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.analytics.FirebaseAnalytics
import com.melvin.ongandroid.R
import com.melvin.ongandroid.databinding.FragmentLogInBinding
import com.melvin.ongandroid.model.data.LoginCredentials
import com.melvin.ongandroid.viewmodel.login.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentLogIn : Fragment() {

    private lateinit var binding: FragmentLogInBinding
    private val viewModel by viewModels<LoginViewModel>()
    private lateinit var analytics: FirebaseAnalytics

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentLogInBinding.inflate(layoutInflater, container, false)
        analytics = FirebaseAnalytics.getInstance(binding.root.context)

        goSignUp()
        buttonEnable()
        validateFields()
        loginGoogle()

        binding.btnLogin.setOnClickListener {
            attemptLogin(
                binding,
                binding.outlinedTextFieldEmail.editText?.text.toString(),
                binding.outlinedTextFieldPassword.editText?.text.toString()
            )
            //Success Analytics Event
            val bundle = Bundle()
            bundle.putString("message", "log_in_pressed")
            analytics.logEvent("log_in_pressed", bundle)
        }

        viewModel.loginStatus.observe(viewLifecycleOwner) {
            if (it) {
                Toast.makeText(requireContext(), "Ingreso exitoso", Toast.LENGTH_SHORT).show()
            } else {
                showDialogLoginError()
            }
        }

        return binding.root

    }

//    val callback = object : OnBackPressedCallback(true){
//        override fun handleOnBackPressed() {
//            findNavController().navigate(R.id.action_nav_log_in_to_mainActivity)
//        }
//    }

    // Navigation to Sign Up fragment
    private fun goSignUp() {
        binding.tvSignUp.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_fragmentLogIn_to_fragmentSignUp)
        }
    }

    // Navigation to Home
    private fun goHome() {
        findNavController().navigate(R.id.action_nav_log_in_to_mainActivity)
    }

    private fun validateFields() {
        val emailUI = binding.outlinedTextFieldEmail
        val passUI = binding.outlinedTextFieldPassword

        //Checks if email valid after changes on editText
        emailUI.editText?.doAfterTextChanged {

            viewModel.validateEmail(it.toString())

            if (!viewModel.validEmail) {
                emailUI.editText!!.error = getString(R.string.invalid_email)
            }
        }

        //Checks if password valid after changes on editText
        passUI.editText?.doAfterTextChanged {

            viewModel.validatePassword(it.toString())

            if (!viewModel.validPassword) {
                passUI.editText!!.error = getString(R.string.invalid_pass)
            }
        }
    }

    //Enables login button if loginButtonLiveData is true
    private fun buttonEnable() {
        viewModel.loginButtonLiveData.observe(viewLifecycleOwner) {
            binding.btnLogin.isEnabled = it
        }
    }

    private fun attemptLogin(binding: FragmentLogInBinding, email: String, password: String) {
        viewModel.logIn(LoginCredentials(email, password))
        if (viewModel.loginStatus.value == true) {
            goHome()
        }
//        when (viewModel.postLoginStatus.value) {
//            LoginViewModel.LoginStatus.ERROR -> showDialogLoginError ()
//            LoginViewModel.LoginStatus.ERROR200 -> showDialogLoginError200 ()
//            else -> goHome()
//        }
    }

    //Dialog when error 200 in login
    private fun showDialogLoginError200() {
        binding.outlinedTextFieldEmail.editText?.error = getString(R.string.invalid_credentials)
        binding.outlinedTextFieldPassword.editText?.error = getString(R.string.invalid_credentials)
    }

    //Message error when invalid login
    private fun showDialogLoginError() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.error_login_dialog))
            .setMessage(
                getString(R.string.error_login_description)
            )
            .setPositiveButton(getString(R.string.ok)) { _, _ -> }
            .show()
    }

    private fun clearFields(binding: FragmentLogInBinding) {
        binding.outlinedTextFieldEmail.editText?.text?.clear()
        binding.outlinedTextFieldPassword.editText?.text?.clear()
    }

    //Sign in with Google
    private fun loginGoogle() {
        binding.btnGoogleLogin.setOnClickListener {
            viewModel.singInGoogle(requireActivity())

            //Success Analytics Event
            val bundle = Bundle()
            bundle.putString("message", "gmail_pressed")
            analytics.logEvent("gmail_pressed", bundle)
        }
    }
}