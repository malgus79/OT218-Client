package com.melvin.ongandroid.di

<<<<<<< HEAD
<<<<<<< HEAD
import com.melvin.ongandroid.model.network.APIServices
=======
import com.melvin.ongandroid.model.APIServices
>>>>>>> 5e4589c (Testimony fragment added)
=======
import com.melvin.ongandroid.model.APIServices
>>>>>>> 5e4589c (Testimony fragment added)
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteModule {

    @Singleton
    @Provides
    fun providesAPIService(retrofit: Retrofit): APIServices {
        return retrofit.create(APIServices::class.java)
    }

    @Singleton
    @Provides
    fun providesRetrofitClient(): Retrofit {

        val loggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client.build())
            .build()
    }
}

const val BASE_URL = "http://ongapi.alkemy.org/"