package com.melvin.ongandroid.view.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.melvin.ongandroid.R
import com.melvin.ongandroid.databinding.FragmentContactBinding
import com.melvin.ongandroid.databinding.FragmentLogInBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentLogIn : Fragment() {

    private lateinit var binding: FragmentLogInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentLogInBinding.inflate(layoutInflater, container, false)

        goSignUp()

        return binding.root

    }

    // Navegation to Sign Up fragment
    private fun goSignUp() {
        binding.btnSignUp.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_fragmentLogIn_to_fragmentSignUp)
        }
    }
}