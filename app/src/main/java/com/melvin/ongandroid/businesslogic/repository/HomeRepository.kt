package com.melvin.ongandroid.businesslogic.repository


import com.melvin.ongandroid.model.data.*
import com.melvin.ongandroid.model.data.activities.ActivitiesList
import com.melvin.ongandroid.model.data.news.NewsList
import com.melvin.ongandroid.model.data.slides.SlidesList
import com.melvin.ongandroid.model.data.testimonials.TestimonialsList
import com.melvin.ongandroid.model.network.APIServices
import retrofit2.Call
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeRepository @Inject constructor(private val APIService: APIServices) {

    //Calls APIServices getHomeSlides suspend function
    suspend fun getHomeSlides(): SlidesList {
        return APIService.getHomeSlides()
    }

    //Calls APIServices getTestimonials function
    suspend fun getTestimonials(): TestimonialsList {
        return APIService.getTestimonials()
    }

    //Calls APIServices getNews function
    suspend fun getNews(): NewsList {
        return APIService.getNews()
    }

    //Calls APIServices getActivities function
    suspend fun getActivities(): ActivitiesList {
        return APIService.getActivities()
    }

    suspend fun getMembers(): MembersList{
        return APIService.getMembers()
    }

    //Calls APIServices postContact function
    suspend fun postContact(contactDTO: ContactDTO): ContactResponse {
        return APIService.postContact(contactDTO)
    }

    fun logIn(loginCredentials: LoginCredentials): Call<LoginResponse>{
        return APIService.login(loginCredentials)
    }

    fun register(registerCredentials: RegisterCredentials): Call<RegisterResponse> {
        return APIService.register(registerCredentials)
    }

}