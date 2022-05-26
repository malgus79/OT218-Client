package com.melvin.ongandroid.model

import com.melvin.ongandroid.model.data.slides.SlidesList
import com.melvin.ongandroid.model.data.testimonials.TestimonialsList
import retrofit2.http.GET

interface APIServices {

    @GET("api/slides")
    suspend fun getHomeSlides(): SlidesList


    //This endpoint returns a list of Testimonials
    @GET("api/testimonials")
    suspend fun getTestimonials(): TestimonialsList


}