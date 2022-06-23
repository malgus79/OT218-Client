package com.melvin.ongandroid.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.melvin.ongandroid.R
import com.melvin.ongandroid.databinding.FragmentContactBinding
import com.melvin.ongandroid.model.network.ApiStatus
import com.melvin.ongandroid.utils.validateFormatEmail
import com.melvin.ongandroid.utils.validateFormatName
import com.melvin.ongandroid.utils.validateFormatQueryMessage
import com.melvin.ongandroid.viewmodel.ContactViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContactFragment : Fragment() {

    private lateinit var binding: FragmentContactBinding
    private val viewModel by viewModels<ContactViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentContactBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.postContactStatus.observe(viewLifecycleOwner, Observer {
            when (it) {
                ApiStatus.LOADING -> isLoading(true)
                ApiStatus.DONE -> {
                    isLoading(false)
                    showSuccessDialog()
                }
                ApiStatus.ERROR -> {
                    isLoading(false)
                    binding.tvContactError.visibility = View.VISIBLE
                }
            }
        })

        buttonEnable()
        validateConsult()

        binding.btnSendMessage.setOnClickListener {
            viewModel.sendMessage(
                binding.etNameField.text.toString(),
                binding.etEmailField.text.toString(),
                binding.etMessageField.text.toString()
            )
        }
    }

    // Tracking the "Send Message" button
    private fun buttonEnable() {
        viewModel.sendMessageButton.observe(viewLifecycleOwner) {
            binding.btnSendMessage.isEnabled = it
        }
    }

    // Check validations of all fields
    private fun validateConsult() {
        val nameUI = binding.cvNameField.editText
        val emailUI = binding.cvEmailField.editText
        val messageUI = binding.cvMessageField.editText

        // Validation: Name field
        nameUI?.doAfterTextChanged {
            viewModel.nameVM.value = it.toString()
            if (!it.toString().validateFormatName()) {
                nameUI.error = getString(R.string.required_name)
            }
            binding.tvContactError.visibility = View.GONE
            viewModel.fieldsValidations()
        }

        // Validation: Email field
        emailUI?.doAfterTextChanged {
            viewModel.emailVM.value = it.toString()
            if (!it.toString().validateFormatEmail()) {
                emailUI.error = getString(R.string.required_email)
            }
            binding.tvContactError.visibility = View.GONE
            viewModel.fieldsValidations()
        }

        // Validation: SendMessage field
        messageUI?.doAfterTextChanged {
            viewModel.queryMessageVM.value = it.toString()
            if (!it.toString().validateFormatQueryMessage()) {
                messageUI.error = getString(R.string.required_send_message)
            }
            binding.tvContactError.visibility = View.GONE
            viewModel.fieldsValidations()
        }
    }

    private fun isLoading(loadingStatus: Boolean) {
        binding.pbPostContact.isVisible = loadingStatus
        binding.etNameField.isEnabled = !loadingStatus
        binding.etEmailField.isEnabled = !loadingStatus
        binding.etMessageField.isEnabled = !loadingStatus
    }

    private fun clearFields() {
        binding.etNameField.text.clear()
        binding.etEmailField.text.clear()
        binding.etMessageField.text.clear()
    }

    private fun showSuccessDialog() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.success_dialog))
            .setMessage(
                getString(R.string.message_sent)
            )
            .setPositiveButton(getString(R.string.ok)) { _, _ -> clearFields() }
            .show()
    }
}