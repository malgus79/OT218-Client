package com.melvin.ongandroid.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.melvin.ongandroid.MainDispatcherRule
import com.melvin.ongandroid.businesslogic.repository.HomeRepository
import com.melvin.ongandroid.model.data.Member
import com.melvin.ongandroid.model.data.MembersList
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
internal class MembersViewModelTest {

    @get:Rule
    var testInstantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()


    @Test
    fun `when members section retrieves data null or Empty`() = runTest {

        //Arrange
        val member = Member(587,
            "Maria Garcia",
            "http://ongapi.alkemy.org/storage/MvPomnLOcv.jpeg",
            "<p>Profesora de Artes Dram&aacute;ticas</p>",
            "https://www.facebook.com/maria-garcia",
            "https://www.linkedin.com/maria-garcia",
            "2022-04-18T00:44:57.000000Z",
            "2022-04-25T18:06:20.000000Z",
            null)
        val membersList = MembersList(false, listOf(), "Members retrieved successfully")

        val repository = mockk<HomeRepository>()

        coEvery { repository.getMembers() } returns membersList


        val membersViewModel = MembersViewModel(repository)

        //Act
        membersViewModel.getMembers()

        //Assert
        assert(membersViewModel.membersList.value?.equals(null) == !membersList.data.isNullOrEmpty())

    }

    @Test
    fun `when members section retrieves data correctly`() = runTest {

        //Arrange
        val member = Member(587,
            "Maria Garcia",
            "http://ongapi.alkemy.org/storage/MvPomnLOcv.jpeg",
            "<p>Profesora de Artes Dram&aacute;ticas</p>",
            "https://www.facebook.com/maria-garcia",
            "https://www.linkedin.com/maria-garcia",
            "2022-04-18T00:44:57.000000Z",
            "2022-04-25T18:06:20.000000Z",
            null)
        val membersList = MembersList(true, listOf(), "Members retrieved successfully")

        val repository = mockk<HomeRepository>()

        coEvery { repository.getMembers() } returns membersList


        val membersViewModel = MembersViewModel(repository)

        //Act
        membersViewModel.getMembers()

        //Assert
        assert(membersViewModel.membersList.value!!.equals(member) == membersList.data?.isNotEmpty())
    }

    @Test
    fun `when members section fail to retrieve data correctly`() = runTest {

        //Arrange
        val membersList = MembersList(false, listOf(), "")

        val repository = mockk<HomeRepository>()

        coEvery { repository.getMembers() } returns membersList

        val membersViewModel = MembersViewModel(repository)

        //Act
        membersViewModel.getMembers()

        //Assert
        assert(membersViewModel.membersList.value?.equals(membersList) == !membersList.data.isNullOrEmpty())
    }
}