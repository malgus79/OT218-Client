package com.melvin.ongandroid.businesslogic.repository

<<<<<<< HEAD
import com.melvin.ongandroid.model.network.APIServices
=======
import com.melvin.ongandroid.model.APIServices
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> e7b752f (Testimonials layout created)
=======
import com.melvin.ongandroid.model.data.news.NewsList
>>>>>>> 5e4589c (Testimony fragment added)
=======
import com.melvin.ongandroid.model.data.news.NewsList
>>>>>>> fa6b629bff1a6b831cd8375919dd7e6066fe9932
import com.melvin.ongandroid.model.data.slides.SlidesList
import com.melvin.ongandroid.model.data.testimonials.Testimonial
import com.melvin.ongandroid.model.data.testimonials.TestimonialsList
<<<<<<< HEAD
=======
import com.melvin.ongandroid.model.data.HomeSlides
import com.melvin.ongandroid.model.data.Testimonials
<<<<<<< HEAD
>>>>>>> 827da8a (Testimonials layout created)
=======
>>>>>>> 827da8a (Testimonials layout created)
=======
>>>>>>> 5e4589c (Testimony fragment added)
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeRepository @Inject constructor(private val APIService: APIServices) {

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
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
=======
    //Search in the repository for the API call
=======
    //Calls APIservice getHomeSlides suspend function
>>>>>>> 827da8a (Testimonials layout created)
    suspend fun getHomeSlides(): HomeSlides {
>>>>>>> bb72910 (Hilt dependencies and spinner  added)
=======
 //Calls APIservice getHomeSlides suspend function
    suspend fun getHomeSlides() : SlidesList {
>>>>>>> 5e4589c (Testimony fragment added)
        return APIService.getHomeSlides()
    }

    //Calls APIservice getTestimonials suspend function
<<<<<<< HEAD
<<<<<<< HEAD
    suspend fun getTestimonials(): Testimonials {
<<<<<<< HEAD
>>>>>>> 827da8a (Testimonials layout created)
=======
>>>>>>> 827da8a (Testimonials layout created)
=======
=======
>>>>>>> fa6b629bff1a6b831cd8375919dd7e6066fe9932
    suspend fun getTestimonials(): TestimonialsList {
>>>>>>> 5e4589c (Testimony fragment added)
        return APIService.getTestimonials()
    }

    //Calls APIService getNews function
    suspend fun getNews(): NewsList {
        return APIService.getNews()
    }

}