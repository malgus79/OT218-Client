package com.melvin.ongandroid.businesslogic.repository

<<<<<<< HEAD
import com.melvin.ongandroid.model.data.news.NewsList
import com.melvin.ongandroid.model.data.slides.SlidesList
import com.melvin.ongandroid.model.data.testimonials.TestimonialsList
import com.melvin.ongandroid.model.network.APIServices
=======
<<<<<<< HEAD
import com.melvin.ongandroid.model.network.APIServices
=======
import com.melvin.ongandroid.model.APIServices
<<<<<<< HEAD
>>>>>>> e7b752f (Testimonials layout created)
import com.melvin.ongandroid.model.data.slides.SlidesList
import com.melvin.ongandroid.model.data.testimonials.TestimonialsList
=======
import com.melvin.ongandroid.model.data.HomeSlides
import com.melvin.ongandroid.model.data.Testimonials
>>>>>>> 827da8a (Testimonials layout created)
>>>>>>> a49bb72 (Testimonials layout created)
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeRepository @Inject constructor(private val APIService: APIServices) {

<<<<<<< HEAD
<<<<<<< HEAD
    //Calls APIService getHomeSlides suspend function
    suspend fun getHomeSlides(): SlidesList {
=======
=======
>>>>>>> a49bb72 (Testimonials layout created)
<<<<<<< HEAD
 //Calls APIservice getHomeSlides suspend function
    suspend fun getHomeSlides() : SlidesList {
=======
    //Search in the repository for the API call
=======
    //Calls APIservice getHomeSlides suspend function
>>>>>>> 827da8a (Testimonials layout created)
    suspend fun getHomeSlides(): HomeSlides {
>>>>>>> bb72910 (Hilt dependencies and spinner  added)
>>>>>>> f744c22 (Hilt dependencies and spinner  added)
        return APIService.getHomeSlides()
    }

<<<<<<< HEAD
    //Calls APIService getTestimonials function
=======
<<<<<<< HEAD
    //Calls APIservice getTestimonials function
>>>>>>> a49bb72 (Testimonials layout created)
    suspend fun getTestimonials(): TestimonialsList {
=======
    //Calls APIservice getTestimonials suspend function
    suspend fun getTestimonials(): Testimonials {
>>>>>>> 827da8a (Testimonials layout created)
        return APIService.getTestimonials()
    }

    //Calls APIService getNews function
    suspend fun getNews(): NewsList {
        return APIService.getNews()
    }

}