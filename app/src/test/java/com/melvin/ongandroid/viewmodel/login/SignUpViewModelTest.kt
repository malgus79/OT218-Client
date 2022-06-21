package com.melvin.ongandroid.viewmodel.login

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.melvin.ongandroid.businesslogic.repository.HomeRepository
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test


class SignUpViewModelTest {

    @get:Rule
    var testInstantTaskExecutorRule= InstantTaskExecutorRule()

    @Test
    fun `when all fields are valid`() = runTest {
        //Arrange
        val name = "Gustavo"
        val email = "Ot218@gmail.com"
        val password = "Val1dpass!"
        val passMatch = "Val1dpass!"

        val repository = mockk<HomeRepository>()

        val viewModel = SignUpViewModel(repository)

        //Act
        viewModel.validateName(name)
        viewModel.validateEmail(email)
        viewModel.validatePassword(password)
        viewModel.validateRepeatPass(passMatch)

        //Assert
        assert(viewModel.validName)
        assert(viewModel.validEmail)
        assert(viewModel.validPassword)
        assert(viewModel.passMatch)
        assert(viewModel.signupButtonLiveData.value == false)
    }

    @Test
    fun `when all fields are empty`() = runTest {
        //Arrange
        val name = ""
        val email = ""
        val password = ""
        val passMatch = ""

        val repository = mockk<HomeRepository>()

        val viewModel = SignUpViewModel(repository)

        //Act
        viewModel.validateName(name)
        viewModel.validateEmail(email)
        viewModel.validatePassword(password)
        viewModel.validateRepeatPass(passMatch)

        //Assert
        assert(viewModel.validName.not())
        assert(viewModel.validEmail.not())
        assert(viewModel.validPassword.not())
        assert(viewModel.passMatch)
        assert(viewModel.signupButtonLiveData.value == false)
    }

    @Test
    fun `when all fields are not valid`() = runTest {
        //Arrange
        val name = "1"
        val email = "OT218@gmail..com"
        val password = "NotVal1dPass"
        val passMatch = "asd"

        val repository = mockk<HomeRepository>()

        val viewModel = SignUpViewModel(repository)

        //Act
        viewModel.validateName(name)
        viewModel.validateEmail(email)
        viewModel.validatePassword(password)
        viewModel.validateRepeatPass(passMatch)

        //Assert
        assert(viewModel.validName.not())
        assert(!viewModel.validEmail)
        assert(!viewModel.validPassword)
        assert(viewModel.passMatch.not())
        assert(viewModel.signupButtonLiveData.value == false)
    }

    @Test
    fun `when only name field is valid`() = runTest {
        //Arrange
        val name = "Gustavo"
        val email = "OT218@gmail..com"
        val password = "NotVal1dPass"
        val passMatch = "asd"

        val repository = mockk<HomeRepository>()

        val viewModel = SignUpViewModel(repository)

        //Act
        viewModel.validateName(name)
        viewModel.validateEmail(email)
        viewModel.validatePassword(password)
        viewModel.validateRepeatPass(passMatch)

        //Assert
        assert(viewModel.validName)
        assert(viewModel.validEmail.not())
        assert(!viewModel.validPassword)
        assert(viewModel.passMatch.not())
        assert(viewModel.signupButtonLiveData.value == false)
    }

    @Test
    fun `when only email field is valid`() = runTest {
        //Arrange
        val name = "1"
        val email = "OT218@gmail.com"
        val password = "NotVal1dPass"
        val passMatch = "asd"

        val repository = mockk<HomeRepository>()

        val viewModel = SignUpViewModel(repository)

        //Act
        viewModel.validateName(name)
        viewModel.validateEmail(email)
        viewModel.validatePassword(password)
        viewModel.validateRepeatPass(passMatch)

        //Assert
        assert(viewModel.validName.not())
        assert(viewModel.validEmail)
        assert(!viewModel.validPassword)
        assert(viewModel.passMatch.not())
        assert(viewModel.signupButtonLiveData.value == false)
    }

    @Test
    fun `when only password field is valid`() = runTest {
        //Arrange
        val name = "1"
        val email = "OT218gmail..com"
        val password = "@Val1dPass"
        val passMatch = "asd"

        val repository = mockk<HomeRepository>()

        val viewModel = SignUpViewModel(repository)

        //Act
        viewModel.validateName(name)
        viewModel.validateEmail(email)
        viewModel.validatePassword(password)
        viewModel.validateRepeatPass(passMatch)

        //Assert
        assert(viewModel.validName.not())
        assert(!viewModel.validEmail)
        assert(viewModel.validPassword)
        assert(viewModel.passMatch.not())
        assert(viewModel.signupButtonLiveData.value == false)
    }

    @Test
    fun `when only password = passmatch field is valid`() = runTest {
        //Arrange
        val name = "1"
        val email = "OT218gmail..com"
        val password = "@Val1dPass"
        val passMatch = "@Val1dPass"

        val repository = mockk<HomeRepository>()

        val viewModel = SignUpViewModel(repository)

        //Act
        viewModel.validateName(name)
        viewModel.validateEmail(email)
        viewModel.validatePassword(password)
        viewModel.validateRepeatPass(passMatch)

        //Assert
        assert(viewModel.validName.not())
        assert(!viewModel.validEmail)
        assert(viewModel.validPassword)
        assert(viewModel.passMatch)
        assert(viewModel.signupButtonLiveData.value == false)
    }

    @Test
    fun `when password and passmatch do not match`() = runTest {
        //Arrange
        val name = "Gustavo"
        val email = "OT218gmail.com"
        val password = "@Val1dPass"
        val passMatch = "@V"

        val repository = mockk<HomeRepository>()

        val viewModel = SignUpViewModel(repository)

        //Act
        viewModel.validateName(name)
        viewModel.validateEmail(email)
        viewModel.validatePassword(password)
        viewModel.validateRepeatPass(passMatch)

        //Assert
        assert(viewModel.validName)
        assert(!viewModel.validEmail)
        assert(viewModel.validPassword)
        assert(viewModel.passMatch.not())
        assert(viewModel.signupButtonLiveData.value == false)
    }
}