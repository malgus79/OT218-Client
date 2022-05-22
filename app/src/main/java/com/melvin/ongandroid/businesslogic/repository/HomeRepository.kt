package com.melvin.ongandroid.businesslogic.repository

import com.melvin.ongandroid.model.APIServiceSlide
import com.melvin.ongandroid.model.data.HomeSlides

class HomeRepository(private val APIService: APIServiceSlide) {

    suspend fun getHomeSlides() : HomeSlides{
        return APIService.getHomeSlides()
    }
}