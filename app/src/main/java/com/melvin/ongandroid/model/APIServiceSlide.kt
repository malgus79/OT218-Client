package com.melvin.ongandroid.model

import com.melvin.ongandroid.model.data.HomeSlides
import retrofit2.http.GET

interface APIServiceSlide {

    //Call Slides
    @GET("api/slides")
    suspend fun getHomeSlides(): HomeSlides
}