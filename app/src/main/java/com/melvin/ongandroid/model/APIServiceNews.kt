package com.melvin.ongandroid.model

import com.melvin.ongandroid.model.data.NewResponse
import retrofit2.Call
import retrofit2.http.GET;

interface APIServiceNews {

    @GET("api/news")
    fun getNews(): Call<NewResponse>
}
