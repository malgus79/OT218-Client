package com.melvin.ongandroid.model


import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "http://ongapi.alkemy.org/"
const val SLIDE_URL = "api/slides"

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


//Create retrofit instance
object ONGApi {
    val retrofitService: APIServices by lazy {
        retrofit.create(APIServices::class.java)
    }
    val newsService: APIServiceNews by lazy {
        retrofit.create(APIServiceNews::class.java)
    }
}
