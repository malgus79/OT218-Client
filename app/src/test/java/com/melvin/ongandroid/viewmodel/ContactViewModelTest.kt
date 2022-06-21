package com.melvin.ongandroid.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.melvin.ongandroid.businesslogic.repository.HomeRepository
import com.melvin.ongandroid.viewmodel.login.LoginViewModel
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

class ContactViewModelTest {

    @get:Rule
    var testInstantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun `when all fields are valid`() = runTest {
        //Arrange
        val name = "Juan Camilo Urbano"
        val email = "camilo12@gmail.com"
        val message = "minimo diez letras 12345678910"

        val repository = mockk<HomeRepository>()

        val viewModel = ContactViewModel(repository)

        //Act
        viewModel.validateName(name)
        viewModel.validateEmail(email)
        viewModel.validateMessage(message)

        //Assert
        assert(viewModel.validEmail)
        assert(viewModel.validName)
        assert(viewModel.validQueryMessage)
        //assert(viewModel.sendMessageButton.value == true)
    }

    @Test
    fun `when all fields are empty`() = runTest {
        //Arrange
        val name = ""
        val email = ""
        val message = ""


        val repository = mockk<HomeRepository>()

        val viewModel = ContactViewModel(repository)

        //Act
        viewModel.validateName(name)
        viewModel.validateEmail(email)
        viewModel.validateMessage(message)

        //Assert
        assert(!viewModel.validEmail)
        assert(!viewModel.validName)
        assert(!viewModel.validQueryMessage)
        //assert(viewModel.sendMessageButton.value == false)
    }

    @Test
    fun `when all fields are not valid`() = runTest {
        //Arrange
        val name = "juan"
        val email = "camilo12com"
        val message = "m"

        val repository = mockk<HomeRepository>()

        val viewModel = ContactViewModel(repository)

        //Act
        viewModel.validateName(name)
        viewModel.validateEmail(email)
        viewModel.validateMessage(message)

        //Assert
        assert(!viewModel.validEmail)
        assert(!viewModel.validName)
        assert(!viewModel.validQueryMessage)
        //assert(viewModel.sendMessageButton.value == false)
    }

    @Test
    fun `when only email field is valid`() = runTest {
        //Arrange
        val email = "camilo12@gmail.com"
        val name = "Juan"
        val message = "m"

        val repository = mockk<HomeRepository>()

        val viewModel = ContactViewModel(repository)

        //Act
        viewModel.validateName(name)
        viewModel.validateEmail(email)
        viewModel.validateMessage(message)

        //Assert
        assert(viewModel.validEmail)
        assert(!viewModel.validName)
        assert(!viewModel.validQueryMessage)
       // assert(viewModel.sendMessageButton.value == false)
    }

    @Test
    fun `when only message field is valid`() = runTest {
        //Arrange
        val email = "camilo12com"
        val name = "Juan"
        val message = "minimo diez letras 12345678910"

        val repository = mockk<HomeRepository>()

        val viewModel = ContactViewModel(repository)

        //Act
        viewModel.validateName(name)
        viewModel.validateEmail(email)
        viewModel.validateMessage(message)

        //Assert
        assert(!viewModel.validEmail)
        assert(!viewModel.validName)
        assert(viewModel.validQueryMessage)
        //assert(viewModel.sendMessageButton.value == false)
    }
}