package com.melvin.ongandroid.model.network

import com.melvin.ongandroid.model.data.news.NewsList
import com.melvin.ongandroid.model.data.slides.SlidesList
import com.melvin.ongandroid.model.data.testimonials.TestimonialsList
import retrofit2.http.GET

interface APIServices {

    //This endpoint returns a list of Slides
    @GET("api/slides")
    suspend fun getHomeSlides(): SlidesList

    //This endpoint returns a list of Testimonials
    @GET("api/testimonials")
    suspend fun getTestimonials(): TestimonialsList

<<<<<<< HEAD:app/src/main/java/com/melvin/ongandroid/model/network/APIServices.kt
=======
    //This endpoint returns a list of News
    @GET("api/news")
    suspend fun getNews(): NewsList

>>>>>>> 5e4589c (Testimony fragment added):app/src/main/java/com/melvin/ongandroid/model/APIServices.kt
}