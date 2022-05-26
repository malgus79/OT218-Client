package com.melvin.ongandroid.businesslogic.repository

<<<<<<< HEAD
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
<<<<<<< HEAD
>>>>>>> e7b752f (Testimonials layout created)
=======
import com.melvin.ongandroid.model.data.news.NewsList
>>>>>>> 5e4589c (Testimony fragment added)
import com.melvin.ongandroid.model.data.slides.SlidesList
import com.melvin.ongandroid.model.data.testimonials.Testimonial
import com.melvin.ongandroid.model.data.testimonials.TestimonialsList
<<<<<<< HEAD
=======
import com.melvin.ongandroid.model.data.HomeSlides
import com.melvin.ongandroid.model.data.Testimonials
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 827da8a (Testimonials layout created)
=======
>>>>>>> 827da8a (Testimonials layout created)
<<<<<<< HEAD
>>>>>>> a49bb72 (Testimonials layout created)
=======
=======
>>>>>>> 5e4589c (Testimony fragment added)
>>>>>>> dd3c420 (Testimony fragment added)
=======
import com.melvin.ongandroid.model.APIServices
<<<<<<< HEAD
import com.melvin.ongandroid.model.data.slides.SlidesList
import com.melvin.ongandroid.model.data.testimonials.TestimonialsList
=======
import com.melvin.ongandroid.model.data.HomeSlides
import com.melvin.ongandroid.model.data.Testimonials
>>>>>>> 827da8a (Testimonials layout created)
>>>>>>> e7b752f (Testimonials layout created)
=======
>>>>>>> 827da8a (Testimonials layout created)
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeRepository @Inject constructor(private val APIService: APIServices) {

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    //Calls APIService getHomeSlides suspend function
    suspend fun getHomeSlides(): SlidesList {
=======
=======
>>>>>>> a49bb72 (Testimonials layout created)
=======
>>>>>>> 9ba56be (Hilt dependencies and spinner  added)
=======
>>>>>>> 919f2e0 (Testimonials layout created)
=======
>>>>>>> dd3c420 (Testimony fragment added)
<<<<<<< HEAD
=======
>>>>>>> c555745 (Hilt dependencies and spinner  added)
=======
>>>>>>> e7b752f (Testimonials layout created)
 //Calls APIservice getHomeSlides suspend function
    suspend fun getHomeSlides() : SlidesList {
=======
    //Search in the repository for the API call
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> e7b752f (Testimonials layout created)
=======
    //Calls APIservice getHomeSlides suspend function
>>>>>>> 827da8a (Testimonials layout created)
    suspend fun getHomeSlides(): HomeSlides {
>>>>>>> bb72910 (Hilt dependencies and spinner  added)
<<<<<<< HEAD
>>>>>>> f744c22 (Hilt dependencies and spinner  added)
=======
=======
    //Search in the repository for the API call
=======
    //Calls APIservice getHomeSlides suspend function
>>>>>>> 827da8a (Testimonials layout created)
    suspend fun getHomeSlides(): HomeSlides {
>>>>>>> bb72910 (Hilt dependencies and spinner  added)
<<<<<<< HEAD
>>>>>>> 9ba56be (Hilt dependencies and spinner  added)
=======
    suspend fun getHomeSlides(): HomeSlides {
>>>>>>> bb72910 (Hilt dependencies and spinner  added)
>>>>>>> c555745 (Hilt dependencies and spinner  added)
=======
    //Search in the repository for the API call
=======
    //Calls APIservice getHomeSlides suspend function
>>>>>>> 827da8a (Testimonials layout created)
    suspend fun getHomeSlides(): HomeSlides {
>>>>>>> bb72910 (Hilt dependencies and spinner  added)
        return APIService.getHomeSlides()
    }

<<<<<<< HEAD
<<<<<<< HEAD
    //Calls APIService getTestimonials function
=======
<<<<<<< HEAD
=======
>>>>>>> e7b752f (Testimonials layout created)
    //Calls APIservice getTestimonials function
>>>>>>> a49bb72 (Testimonials layout created)
    suspend fun getTestimonials(): TestimonialsList {
=======
<<<<<<< HEAD
=======
=======
 //Calls APIservice getHomeSlides suspend function
    suspend fun getHomeSlides() : SlidesList {
>>>>>>> 5e4589c (Testimony fragment added)
        return APIService.getHomeSlides()
    }

>>>>>>> dd3c420 (Testimony fragment added)
    //Calls APIservice getTestimonials suspend function
<<<<<<< HEAD
<<<<<<< HEAD
    suspend fun getTestimonials(): Testimonials {
<<<<<<< HEAD
>>>>>>> 827da8a (Testimonials layout created)
=======
>>>>>>> 827da8a (Testimonials layout created)
=======
    suspend fun getTestimonials(): TestimonialsList {
>>>>>>> 5e4589c (Testimony fragment added)
=======
    //Calls APIservice getTestimonials suspend function
    suspend fun getTestimonials(): Testimonials {
>>>>>>> 827da8a (Testimonials layout created)
>>>>>>> e7b752f (Testimonials layout created)
        return APIService.getTestimonials()
    }

    //Calls APIService getNews function
    suspend fun getNews(): NewsList {
        return APIService.getNews()
    }

=======
    suspend fun getTestimonials(): Testimonials {
        return APIService.getTestimonials()
    }

>>>>>>> 827da8a (Testimonials layout created)
}