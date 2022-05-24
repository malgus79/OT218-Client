package com.melvin.ongandroid.businesslogic.repository

import com.melvin.ongandroid.model.APIServiceNews
import com.melvin.ongandroid.model.data.NewResponse
import retrofit2.Call

class NewsRepository(private val APIService: APIServiceNews) {

    suspend fun getNews(): Call<NewResponse> {
        return APIService.getNews()
    }
}