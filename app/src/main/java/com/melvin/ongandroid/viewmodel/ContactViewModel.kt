package com.melvin.ongandroid.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melvin.ongandroid.businesslogic.repository.HomeRepository
import com.melvin.ongandroid.model.data.ContactDTO
import com.melvin.ongandroid.model.network.ApiStatus
import com.melvin.ongandroid.utils.validateFormatEmail
import com.melvin.ongandroid.utils.validateFormatName
import com.melvin.ongandroid.utils.validateFormatQueryMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel() {


    // Fields of the contact fragment
    val nameVM = MutableLiveData("")
    val emailVM = MutableLiveData("")
    val queryMessageVM = MutableLiveData("")

    // Internal MutableLiveData - Enable "send message" button
    private val _sendMessageButton = MutableLiveData(false)
    // External LiveData - Enable "send message" button
    val sendMessageButton: LiveData<Boolean> = _sendMessageButton

    // Internal MutableLiveData - Api state
    private val _postContactStatus = MutableLiveData<ApiStatus>()
    // External LiveData - Api state
    val postContactStatus: LiveData<ApiStatus> = _postContactStatus

    // Fields to validate
    var validName = false
    var validEmail = false
    var validQueryMessage = false

    // Validation of form fields and enable "send message" button
    fun fieldsValidations() {
        validName = nameVM.value.toString().validateFormatName()
        validEmail = emailVM.value.toString().validateFormatEmail()
        validQueryMessage = queryMessageVM.value.toString().validateFormatQueryMessage()
        val validated = validName && validEmail && validQueryMessage
        _sendMessageButton.postValue(validated)
    }

    //calls repository postContact function and updates status
    fun sendMessage(name: String, email: String, message: String) {
        _postContactStatus.value = ApiStatus.LOADING
        val contactDTO = ContactDTO(name,email,message)
        viewModelScope.launch {
              val postContactResponse = repository.postContact(contactDTO)
                if (postContactResponse.success == true){
                    _postContactStatus.value = ApiStatus.DONE
                }else{
                    _postContactStatus.value = ApiStatus.ERROR
                }
        }
    }
}