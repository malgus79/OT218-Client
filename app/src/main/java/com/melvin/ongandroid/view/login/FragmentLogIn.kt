package com.melvin.ongandroid.view.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.melvin.ongandroid.R
import com.melvin.ongandroid.databinding.FragmentLogInBinding
import com.melvin.ongandroid.model.data.LoginCredentials
import com.melvin.ongandroid.utils.validateFormatEmail
import com.melvin.ongandroid.utils.validateFormatPassword
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

        binding.btnLogin.setOnClickListener {
            attemptLogin(binding,binding.outlinedTextFieldEmail.editText?.text.toString(),binding.outlinedTextFieldPassword.editText?.text.toString())
        }

        return binding.root

    }

    // Navegation to Sign Up fragment
    private fun goSignUp() {
        binding.btnSignUp.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_fragmentLogIn_to_fragmentSignUp)
        }
    }
    
    private fun validateFields() {
        val emailUI = binding.outlinedTextFieldEmail
        val passUI = binding.outlinedTextFieldPassword

        //Checks if email valid after changes on editText
        emailUI.editText?.doAfterTextChanged {
            if (it.toString().validateFormatEmail()){
                viewModel.setEmailData(it.toString())
                viewModel.validEmail = true
            } else{
                emailUI.editText!!.error = getString(R.string.invalid_email)
                viewModel.validEmail = false
            }
            viewModel.setLoginButtonLiveData()
        }

        //Checks if password valid after changes on editText
        passUI.editText?.doAfterTextChanged {
            if (it.toString().validateFormatPassword()){
                viewModel.setPasswordData(it.toString())
                viewModel.validPassword = true
            } else{
                passUI.editText!!.error = getString(R.string.invalid_pass)
                viewModel.validPassword = false
            }
            viewModel.setLoginButtonLiveData()
        }


    }

    //Enables login button if loginButtonLiveData is true
    private fun buttonEnable() {
        viewModel.loginButtonLiveData.observe(viewLifecycleOwner){
            binding.btnLogin.isEnabled = it
        }
    }

    private fun attemptLogin (binding: FragmentLogInBinding,email: String, password: String) {

        viewModel.logIn(LoginCredentials(email,password))
    }

    private fun clearFields(binding: FragmentLogInBinding){
        binding.outlinedTextFieldEmail.editText?.text?.clear()
        binding.outlinedTextFieldPassword.editText?.text?.clear()
    }
}