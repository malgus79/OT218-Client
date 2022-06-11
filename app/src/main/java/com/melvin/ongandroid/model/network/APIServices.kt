package com.melvin.ongandroid.model.network

import com.melvin.ongandroid.model.data.MembersList
import com.melvin.ongandroid.model.data.ContactDTO
import com.melvin.ongandroid.model.data.ContactResponse
import com.melvin.ongandroid.model.data.activities.ActivitiesList
import com.melvin.ongandroid.model.data.news.NewsList
import com.melvin.ongandroid.model.data.slides.SlidesList
import com.melvin.ongandroid.model.data.testimonials.TestimonialsList
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface APIServices {

    //This endpoint returns a list of Slides
    @GET("api/slides")
    suspend fun getHomeSlides(): SlidesList

    //This endpoint returns a list of Testimonials
    @GET("api/testimonials")
    suspend fun getTestimonials(): TestimonialsList

    //This endpoint returns a list of News
    @GET("api/news")
    suspend fun getNews(): NewsList

    //This endpoint returns a list of Activities
    @GET("api/activities")
    suspend fun getActivities(): ActivitiesList

    @GET("api/members")
    suspend fun getMembers(): MembersList

    @POST("api/contacts")
    suspend fun postContact(@Body contactDTO: ContactDTO): ContactResponse


}