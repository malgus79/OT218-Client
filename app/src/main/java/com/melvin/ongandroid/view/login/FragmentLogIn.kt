package com.melvin.ongandroid.view.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.melvin.ongandroid.R
import com.melvin.ongandroid.databinding.FragmentLogInBinding
import com.melvin.ongandroid.model.data.LoginCredentials
import com.melvin.ongandroid.utils.validateFormatEmail
import com.melvin.ongandroid.utils.validateFormatPassword
import com.melvin.ongandroid.view.MainActivity
import com.melvin.ongandroid.view.fragment.HomeFragment
import com.melvin.ongandroid.viewmodel.login.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentLogIn : Fragment() {

    private lateinit var binding: FragmentLogInBinding
    private val viewModel by viewModels<LoginViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentLogInBinding.inflate(layoutInflater, container, false)

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

            if (!viewModel.validPassword){
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
    }

    private fun clearFields(binding: FragmentLogInBinding) {
        binding.outlinedTextFieldEmail.editText?.text?.clear()
        binding.outlinedTextFieldPassword.editText?.text?.clear()
    }

    //Sign in with Google
    private fun loginGoogle() {
        binding.btnGoogleLogin.setOnClickListener {
            viewModel.singInGoogle(requireActivity())
        }
    }
}