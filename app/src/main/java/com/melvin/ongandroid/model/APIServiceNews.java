package com.melvin.ongandroid.model;


import retrofit2.http.GET;

interface APIServiceNews {

    @GET("api/news")
    suspend fun getNews(): NewResponse
}
