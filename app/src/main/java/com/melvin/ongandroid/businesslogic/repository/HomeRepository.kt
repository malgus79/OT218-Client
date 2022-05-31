package com.melvin.ongandroid.businesslogic.repository

<<<<<<< HEAD
import com.melvin.ongandroid.model.data.activities.ActivitiesList
=======
>>>>>>> ee97f54ad755c3795943cd7fc03e4f3485834fc8
import com.melvin.ongandroid.model.data.news.NewsList
import com.melvin.ongandroid.model.data.slides.SlidesList
import com.melvin.ongandroid.model.data.testimonials.TestimonialsList
import com.melvin.ongandroid.model.network.APIServices
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeRepository @Inject constructor(private val APIService: APIServices) {

<<<<<<< HEAD
    //Calls APIServices getHomeSlides suspend function
    suspend fun getHomeSlides(): SlidesList {
        return APIService.getHomeSlides()
    }

    //Calls APIServices getTestimonials function
=======
    //Calls APIservice getHomeSlides suspend function
    suspend fun getHomeSlides(): SlidesList {

        return APIService.getHomeSlides()
    }

    //Calls APIservice getTestimonials suspend function
>>>>>>> ee97f54ad755c3795943cd7fc03e4f3485834fc8
    suspend fun getTestimonials(): TestimonialsList {
        return APIService.getTestimonials()
    }

<<<<<<< HEAD
    //Calls APIServices getNews function
=======
    //Calls APIService getNews function
>>>>>>> ee97f54ad755c3795943cd7fc03e4f3485834fc8
    suspend fun getNews(): NewsList {
        return APIService.getNews()
    }

<<<<<<< HEAD
    //Calls APIservices getActivites function
    suspend fun getActivites(): ActivitiesList{
        return APIService.getActivities()
    }

=======
>>>>>>> ee97f54ad755c3795943cd7fc03e4f3485834fc8
}