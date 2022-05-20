package com.melvin.ongandroid.model


import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient


const val BASE_URL = "http://ongapi.alkemy.org/"

//Create logging interceptor
private val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

//Create OkHttp Client
private val client = OkHttpClient.Builder()
    .addInterceptor(loggingInterceptor)

//Create Retrofit Builder
private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .client(client.build())
    .build()

enum class ApiStatus {LOADING, ERROR, DONE}

interface APIService {
    //TODO Add request functions
}

//Create retrofit instance
object ONGApi {
    val retrofitService: APIService by lazy {
        retrofit.create(APIService::class.java)
    }
}
