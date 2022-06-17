package com.melvin.ongandroid.view.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.melvin.ongandroid.R
import com.melvin.ongandroid.databinding.FragmentSignUpBinding
import com.melvin.ongandroid.viewmodel.login.LoginViewModel
import com.melvin.ongandroid.viewmodel.login.SignUpViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentSignUp : Fragment() {

    private lateinit var binding: FragmentSignUpBinding
    private val viewModel by viewModels<SignUpViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentSignUpBinding.inflate(layoutInflater, container, false)

        goLogIn()
        enableSignupButton()
        validateFields()

        return binding.root
    }

    // Navegation to Log In fragment
    private fun goLogIn() {
        binding.tvHaveAccountLogIn.setOnClickListener {
            it.findNavController().popBackStack()
        }
    }

    //Enables signup button if signupButtonLiveData is true
    private fun enableSignupButton() {
        viewModel.signupButtonLiveData.observe(viewLifecycleOwner) {
            binding.btnSignUp.isEnabled = it
        }
    }

    private fun validateFields() {
        val nameUI = binding.outlinedTextFieldName
        val emailUI = binding.outlinedTextFieldEmail
        val passUI = binding.outlinedTextFieldPassword
        val repeatPassUI = binding.outlinedTextFieldRepeatPassword

        //Checks if name valid after changes on editText
        nameUI.editText?.doAfterTextChanged {
            viewModel.validateName(it.toString())
            if (!viewModel.validName) {
                nameUI.error = getString(R.string.required_name)
            } else {
                nameUI.error = null
            }
            viewModel.setSignupButtonLiveData()
        }

        //Checks if email valid after changes on editText
        emailUI.editText?.doAfterTextChanged {
            viewModel.validateEmail(it.toString())
            if (!viewModel.validEmail) {
                emailUI.error = getString(R.string.invalid_email)
            } else {
                emailUI.error = null
            }

            viewModel.setSignupButtonLiveData()
        }

        //Checks if pass valid after changes on editText
        passUI.editText?.doAfterTextChanged {
            viewModel.validatePassword(it.toString())
            if (!viewModel.validPassword) {
                passUI.error = getString(R.string.invalid_pass)
            } else {
                passUI.error = null
            }
            if (!viewModel.passMatch) {
                repeatPassUI.error = getString(R.string.pass_dont_match)
            } else {
                repeatPassUI.error = null
            }
            viewModel.setSignupButtonLiveData()
        }

        //Checks pass match after changes on editText
        repeatPassUI.editText?.doAfterTextChanged {
            viewModel.validateRepeatPass(it.toString())
            if (!viewModel.passMatch) {
                repeatPassUI.error = getString(R.string.pass_dont_match)
            } else {
                repeatPassUI.error = null
            }
            viewModel.setSignupButtonLiveData()
        }
    }
}