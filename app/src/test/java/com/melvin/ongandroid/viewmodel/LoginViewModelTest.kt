package com.melvin.ongandroid.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.melvin.ongandroid.businesslogic.repository.HomeRepository
import com.melvin.ongandroid.viewmodel.login.LoginViewModel
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test


class LoginViewModelTest {

    @get:Rule
    var testInstantTaskExecutorRule= InstantTaskExecutorRule()

    @Test
    fun `when both fields are valid`() = runTest {
        //Arrange
        val email = "Ot218@gmail.com"
        val password = "Val1dpass!"

        val repository = mockk<HomeRepository>()

        val viewModel = LoginViewModel(repository)

        //Act
        viewModel.validateEmail(email)
        viewModel.validatePassword(password)

        //Assert
        assert(viewModel.validEmail)
        assert(viewModel.validPassword)
        assert(viewModel.loginButtonLiveData.value == true)
    }

    @Test
    fun `when both fields are empty`() = runTest {
        //Arrange
        val email = ""
        val password = ""

        val repository = mockk<HomeRepository>()

        val viewModel = LoginViewModel(repository)

        //Act
        viewModel.validateEmail(email)
        viewModel.validatePassword(password)

        //Assert
        assert(!viewModel.validEmail)
        assert(!viewModel.validPassword)
        assert(viewModel.loginButtonLiveData.value == false)
    }

    @Test
    fun `when both fields are not valid`() = runTest {
        //Arrange
        val email = "OT218@gmail..com"
        val password = "NotVal1dPass"

        val repository = mockk<HomeRepository>()

        val viewModel = LoginViewModel(repository)

        //Act
        viewModel.validateEmail(email)
        viewModel.validatePassword(password)

        //Assert
        assert(!viewModel.validEmail)
        assert(!viewModel.validPassword)
        assert(viewModel.loginButtonLiveData.value == false)
    }

    @Test
    fun `when only email field is valid`() = runTest {
        //Arrange
        val email = "OT218@gmail.com"
        val password = "NotVal1dPass"

        val repository = mockk<HomeRepository>()

        val viewModel = LoginViewModel(repository)

        //Act
        viewModel.validateEmail(email)
        viewModel.validatePassword(password)

        //Assert
        assert(viewModel.validEmail)
        assert(!viewModel.validPassword)
        assert(viewModel.loginButtonLiveData.value == false)
    }

    @Test
    fun `when only password field is valid`() = runTest {
        //Arrange
        val email = "OT218gmail.com"
        val password = "@Val1dPass"

        val repository = mockk<HomeRepository>()

        val viewModel = LoginViewModel(repository)

        //Act
        viewModel.validateEmail(email)
        viewModel.validatePassword(password)

        //Assert
        assert(!viewModel.validEmail)
        assert(viewModel.validPassword)
        assert(viewModel.loginButtonLiveData.value == false)
    }

}