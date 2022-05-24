package com.melvin.ongandroid.model

<<<<<<< HEAD
import com.melvin.ongandroid.model.data.slides.SlidesList
import com.melvin.ongandroid.model.data.testimonials.TestimonialsList
=======
import com.melvin.ongandroid.model.data.HomeSlides
import com.melvin.ongandroid.model.data.News
import com.melvin.ongandroid.model.data.Testimonials
>>>>>>> f06885f (News added: fragment, adapter, view, and service)
import retrofit2.http.GET

interface APIServices {

    //This endpoint returns a list of Slides
    @GET("api/slides")
    suspend fun getHomeSlides(): SlidesList


    //This endpoint returns a list of Testimonials
    @GET("api/testimonials")
    suspend fun getTestimonials(): TestimonialsList

    @GET("api/news")
    suspend fun getNews(): News

}