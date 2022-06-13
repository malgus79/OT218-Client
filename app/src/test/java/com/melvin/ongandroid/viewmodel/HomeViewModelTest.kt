package com.melvin.ongandroid.viewmodel


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.melvin.ongandroid.MainDispatcherRule
import com.melvin.ongandroid.businesslogic.repository.HomeRepository
import com.melvin.ongandroid.model.data.news.New
import com.melvin.ongandroid.model.data.news.NewsList
import com.melvin.ongandroid.model.data.slides.Slide
import com.melvin.ongandroid.model.data.slides.SlidesList
import com.melvin.ongandroid.model.data.testimonials.Testimonial
import com.melvin.ongandroid.model.data.testimonials.TestimonialsList
import com.melvin.ongandroid.model.network.ApiStatus
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test




@ExperimentalCoroutinesApi
class HomeViewModelTest(){

    @get:Rule
    var testInstantTaskExecutorRule= InstantTaskExecutorRule()
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()


    @Test
    fun `when all sections retrieves data correctly` () = runTest {

       //Arrange
        val slide = Slide(1367,"Sumate","Sumate a nuestros proyectos Juntos Somos Más","http://ongapi.alkemy.org/storage/9BkzVmW80A.jpeg","2022-05-26T15:06:11.000000Z",null,null,3,"2022-05-26T15:06:11.000000Z",null)
        val slidesList = SlidesList(listOf(slide),"Slides retrieved successfully",true)

        val new = New(2090,"Recital a beneficio",null,"asdasd","http://ongapi.alkemy.org/storage/J6VLsBWoFD.jpeg",null,2057,"2022-04-24T18:28:28.000000Z","2022-06-02T00:28:58.000000Z",null)
        val newsList = NewsList(listOf(new),"News retrieved successfully",true)

        val testimonial = Testimonial(466,"Noelia Acevedo","http://ongapi.alkemy.org/storage/npYfHB9gMF.jpg","Somos Más ayuda a incorporar en la vida de los niños y adolescentes hábitos sanos, mediante actividades que les brinda contención emocional y afectiva.","2022-03-28T20:33:00.000000Z","2022-03-28T20:33:00.000000Z",null,42)
        val testimonialsList = TestimonialsList(true,listOf(testimonial),"Testimonials retrieved successfully")

        val homeRepository = mockk<HomeRepository>()

        coEvery { homeRepository.getHomeSlides() } returns slidesList
        coEvery { homeRepository.getNews() } returns newsList
        coEvery { homeRepository.getTestimonials() } returns testimonialsList


        val homeViewModel = HomeViewModel(homeRepository)

        //Act
        homeViewModel.getSlides()
        homeViewModel.getNews()
        homeViewModel.getTestimonials()
        homeViewModel.combineHomeStatusData(homeViewModel.slidesStatus,homeViewModel.newsStatus,homeViewModel.testimonialsStatus)



        //Assert
        assert(homeViewModel.slidesList.value == slidesList)
        assert(homeViewModel.slidesList.value?.slide?.first()?.id == 1367 )
        assert(homeViewModel.slidesStatus.value == ApiStatus.DONE)

        assert(homeViewModel.newsList.value == newsList)
        assert(homeViewModel.newsList.value?.data?.first()?.id == 2090 )
        assert(homeViewModel.newsStatus.value == ApiStatus.DONE)

        assert(homeViewModel.testimonialsList.value == testimonialsList)
        assert(homeViewModel.testimonialsList.value?.testimonials?.first()?.id == 466 )
        assert(homeViewModel.testimonialsStatus.value == ApiStatus.DONE)

        assert(homeViewModel.homeStatusLiveDataMerger.value == ApiStatus.DONE)



    }

    @Test
    fun `when all sections fail to retrieve data correctly` () = runTest {

        //Arrange
        val slidesList = SlidesList(listOf(),"",false)

        val newsList = NewsList(listOf(),"",false)

        val testimonialsList = TestimonialsList(false,listOf(),"")

        val homeRepository = mockk<HomeRepository>()

        coEvery { homeRepository.getHomeSlides() } returns slidesList
        coEvery { homeRepository.getNews() } returns newsList
        coEvery { homeRepository.getTestimonials() } returns testimonialsList

        val homeViewModel = HomeViewModel(homeRepository)

        //Act
        homeViewModel.getSlides()
        homeViewModel.getNews()
        homeViewModel.getTestimonials()
        homeViewModel.combineHomeStatusData(homeViewModel.slidesStatus,homeViewModel.newsStatus,homeViewModel.testimonialsStatus)



        //Assert
        assert(homeViewModel.slidesList.value?.slide.isNullOrEmpty())
        assert(homeViewModel.slidesStatus.value == ApiStatus.ERROR)

        assert(homeViewModel.newsList.value?.data.isNullOrEmpty())
        assert(homeViewModel.newsStatus.value == ApiStatus.ERROR)

        assert(homeViewModel.testimonialsList.value?.testimonials.isNullOrEmpty())
        assert(homeViewModel.testimonialsStatus.value == ApiStatus.ERROR)

        assert(homeViewModel.homeStatusLiveDataMerger.value == ApiStatus.ERROR)



    }

    @Test
    fun `when only slides fails` () = runTest {

        //Arrange
        val slidesList = SlidesList(listOf(),"",false)

        val new = New(2090,"Recital a beneficio",null,"asdasd","http://ongapi.alkemy.org/storage/J6VLsBWoFD.jpeg",null,2057,"2022-04-24T18:28:28.000000Z","2022-06-02T00:28:58.000000Z",null)
        val newsList = NewsList(listOf(new),"News retrieved successfully",true)

        val testimonial = Testimonial(466,"Noelia Acevedo","http://ongapi.alkemy.org/storage/npYfHB9gMF.jpg","Somos Más ayuda a incorporar en la vida de los niños y adolescentes hábitos sanos, mediante actividades que les brinda contención emocional y afectiva.","2022-03-28T20:33:00.000000Z","2022-03-28T20:33:00.000000Z",null,42)
        val testimonialsList = TestimonialsList(true,listOf(testimonial),"Testimonials retrieved successfully")

        val homeRepository = mockk<HomeRepository>()

        coEvery { homeRepository.getHomeSlides() } returns slidesList
        coEvery { homeRepository.getNews() } returns newsList
        coEvery { homeRepository.getTestimonials() } returns testimonialsList

        val homeViewModel = HomeViewModel(homeRepository)

        //Act
        homeViewModel.getSlides()
        homeViewModel.getNews()
        homeViewModel.getTestimonials()
        homeViewModel.combineHomeStatusData(homeViewModel.slidesStatus,homeViewModel.newsStatus,homeViewModel.testimonialsStatus)

        //Assert
        assert(homeViewModel.slidesList.value?.slide.isNullOrEmpty())
        assert(homeViewModel.slidesStatus.value == ApiStatus.ERROR)

        assert(homeViewModel.newsList.value == newsList)
        assert(homeViewModel.newsList.value?.data?.first()?.id == 2090 )
        assert(homeViewModel.newsStatus.value == ApiStatus.DONE)

        assert(homeViewModel.testimonialsList.value == testimonialsList)
        assert(homeViewModel.testimonialsList.value?.testimonials?.first()?.id == 466 )
        assert(homeViewModel.testimonialsStatus.value == ApiStatus.DONE)

        assert(homeViewModel.homeStatusLiveDataMerger.value == ApiStatus.ERROR)

    }


    @Test
    fun `when only news fails` () = runTest {

        //Arrange
        val slide = Slide(1367,"Sumate","Sumate a nuestros proyectos Juntos Somos Más","http://ongapi.alkemy.org/storage/9BkzVmW80A.jpeg","2022-05-26T15:06:11.000000Z",null,null,3,"2022-05-26T15:06:11.000000Z",null)
        val slidesList = SlidesList(listOf(slide),"Slides retrieved successfully",true)

        val newsList = NewsList(listOf(),"",false)

        val testimonial = Testimonial(466,"Noelia Acevedo","http://ongapi.alkemy.org/storage/npYfHB9gMF.jpg","Somos Más ayuda a incorporar en la vida de los niños y adolescentes hábitos sanos, mediante actividades que les brinda contención emocional y afectiva.","2022-03-28T20:33:00.000000Z","2022-03-28T20:33:00.000000Z",null,42)
        val testimonialsList = TestimonialsList(true,listOf(testimonial),"Testimonials retrieved successfully")

        val homeRepository = mockk<HomeRepository>()

        coEvery { homeRepository.getHomeSlides() } returns slidesList
        coEvery { homeRepository.getNews() } returns newsList
        coEvery { homeRepository.getTestimonials() } returns testimonialsList

        val homeViewModel = HomeViewModel(homeRepository)

        //Act
        homeViewModel.getSlides()
        homeViewModel.getNews()
        homeViewModel.getTestimonials()
        homeViewModel.combineHomeStatusData(homeViewModel.slidesStatus,homeViewModel.newsStatus,homeViewModel.testimonialsStatus)

        //Assert
        assert(homeViewModel.slidesList.value == slidesList)
        assert(homeViewModel.slidesList.value?.slide?.first()?.id == 1367 )
        assert(homeViewModel.slidesStatus.value == ApiStatus.DONE)

        assert(homeViewModel.newsList.value?.data.isNullOrEmpty())
        assert(homeViewModel.newsStatus.value == ApiStatus.ERROR)

        assert(homeViewModel.testimonialsList.value == testimonialsList)
        assert(homeViewModel.testimonialsList.value?.testimonials?.first()?.id == 466 )
        assert(homeViewModel.testimonialsStatus.value == ApiStatus.DONE)

        assert(homeViewModel.homeStatusLiveDataMerger.value == ApiStatus.ERROR)

    }

    @Test
    fun `when only testimonials fails` () = runTest {

        //Arrange
        val slide = Slide(1367,"Sumate","Sumate a nuestros proyectos Juntos Somos Más","http://ongapi.alkemy.org/storage/9BkzVmW80A.jpeg","2022-05-26T15:06:11.000000Z",null,null,3,"2022-05-26T15:06:11.000000Z",null)
        val slidesList = SlidesList(listOf(slide),"Slides retrieved successfully",true)

        val new = New(2090,"Recital a beneficio",null,"asdasd","http://ongapi.alkemy.org/storage/J6VLsBWoFD.jpeg",null,2057,"2022-04-24T18:28:28.000000Z","2022-06-02T00:28:58.000000Z",null)
        val newsList = NewsList(listOf(new),"News retrieved successfully",true)

        val testimonialsList = TestimonialsList(false, listOf(),"")

        val homeRepository = mockk<HomeRepository>()

        coEvery { homeRepository.getHomeSlides() } returns slidesList
        coEvery { homeRepository.getNews() } returns newsList
        coEvery { homeRepository.getTestimonials() } returns testimonialsList

        val homeViewModel = HomeViewModel(homeRepository)

        //Act
        homeViewModel.getSlides()
        homeViewModel.getNews()
        homeViewModel.getTestimonials()
        homeViewModel.combineHomeStatusData(homeViewModel.slidesStatus,homeViewModel.newsStatus,homeViewModel.testimonialsStatus)

        //Assert
        assert(homeViewModel.slidesList.value == slidesList)
        assert(homeViewModel.slidesList.value?.slide?.first()?.id == 1367 )
        assert(homeViewModel.slidesStatus.value == ApiStatus.DONE)

        assert(homeViewModel.newsList.value == newsList)
        assert(homeViewModel.newsList.value?.data?.first()?.id == 2090 )
        assert(homeViewModel.newsStatus.value == ApiStatus.DONE)

        assert(homeViewModel.testimonialsList.value?.testimonials.isNullOrEmpty())
        assert(homeViewModel.testimonialsStatus.value == ApiStatus.ERROR)

        assert(homeViewModel.homeStatusLiveDataMerger.value == ApiStatus.ERROR)

    }

    @Test
    fun `when only slides retrieves data correctly` () = runTest {

        //Arrange
        val slide = Slide(1367,"Sumate","Sumate a nuestros proyectos Juntos Somos Más","http://ongapi.alkemy.org/storage/9BkzVmW80A.jpeg","2022-05-26T15:06:11.000000Z",null,null,3,"2022-05-26T15:06:11.000000Z",null)
        val slidesList = SlidesList(listOf(slide),"Slides retrieved successfully",true)

        val newsList = NewsList(listOf(),"",false)

        val testimonialsList = TestimonialsList(false, listOf(),"")

        val homeRepository = mockk<HomeRepository>()

        coEvery { homeRepository.getHomeSlides() } returns slidesList
        coEvery { homeRepository.getNews() } returns newsList
        coEvery { homeRepository.getTestimonials() } returns testimonialsList

        val homeViewModel = HomeViewModel(homeRepository)

        //Act
        homeViewModel.getSlides()
        homeViewModel.getNews()
        homeViewModel.getTestimonials()
        homeViewModel.combineHomeStatusData(homeViewModel.slidesStatus,homeViewModel.newsStatus,homeViewModel.testimonialsStatus)

        //Assert
        assert(homeViewModel.slidesList.value == slidesList)
        assert(homeViewModel.slidesList.value?.slide?.first()?.id == 1367 )
        assert(homeViewModel.slidesStatus.value == ApiStatus.DONE)

        assert(homeViewModel.newsList.value?.data.isNullOrEmpty())
        assert(homeViewModel.newsStatus.value == ApiStatus.ERROR)

        assert(homeViewModel.testimonialsList.value?.testimonials.isNullOrEmpty())
        assert(homeViewModel.testimonialsStatus.value == ApiStatus.ERROR)

        assert(homeViewModel.homeStatusLiveDataMerger.value == ApiStatus.ERROR)

    }

    @Test
    fun `when only news retrieves data correctly` () = runTest {

        //Arrange
        val slidesList = SlidesList(listOf(),"",false)

        val new = New(2090,"Recital a beneficio",null,"asdasd","http://ongapi.alkemy.org/storage/J6VLsBWoFD.jpeg",null,2057,"2022-04-24T18:28:28.000000Z","2022-06-02T00:28:58.000000Z",null)
        val newsList = NewsList(listOf(new),"News retrieved successfully",true)

        val testimonialsList = TestimonialsList(false, listOf(),"")

        val homeRepository = mockk<HomeRepository>()

        coEvery { homeRepository.getHomeSlides() } returns slidesList
        coEvery { homeRepository.getNews() } returns newsList
        coEvery { homeRepository.getTestimonials() } returns testimonialsList

        val homeViewModel = HomeViewModel(homeRepository)

        //Act
        homeViewModel.getSlides()
        homeViewModel.getNews()
        homeViewModel.getTestimonials()
        homeViewModel.combineHomeStatusData(homeViewModel.slidesStatus,homeViewModel.newsStatus,homeViewModel.testimonialsStatus)

        //Assert
        assert(homeViewModel.slidesList.value?.slide.isNullOrEmpty())
        assert(homeViewModel.slidesStatus.value == ApiStatus.ERROR)

        assert(homeViewModel.newsList.value == newsList)
        assert(homeViewModel.newsList.value?.data?.first()?.id == 2090 )
        assert(homeViewModel.newsStatus.value == ApiStatus.DONE)

        assert(homeViewModel.testimonialsList.value?.testimonials.isNullOrEmpty())
        assert(homeViewModel.testimonialsStatus.value == ApiStatus.ERROR)

        assert(homeViewModel.homeStatusLiveDataMerger.value == ApiStatus.ERROR)

    }

    @Test
    fun `when only testimonials retrieves data correctly` () = runTest {

        //Arrange
        val slidesList = SlidesList(listOf(),"",false)

        val newsList = NewsList(listOf(),"",false)

        val testimonial = Testimonial(466,"Noelia Acevedo","http://ongapi.alkemy.org/storage/npYfHB9gMF.jpg","Somos Más ayuda a incorporar en la vida de los niños y adolescentes hábitos sanos, mediante actividades que les brinda contención emocional y afectiva.","2022-03-28T20:33:00.000000Z","2022-03-28T20:33:00.000000Z",null,42)
        val testimonialsList = TestimonialsList(true,listOf(testimonial),"Testimonials retrieved successfully")

        val homeRepository = mockk<HomeRepository>()

        coEvery { homeRepository.getHomeSlides() } returns slidesList
        coEvery { homeRepository.getNews() } returns newsList
        coEvery { homeRepository.getTestimonials() } returns testimonialsList

        val homeViewModel = HomeViewModel(homeRepository)

        //Act
        homeViewModel.getSlides()
        homeViewModel.getNews()
        homeViewModel.getTestimonials()
        homeViewModel.combineHomeStatusData(homeViewModel.slidesStatus,homeViewModel.newsStatus,homeViewModel.testimonialsStatus)

        //Assert
        assert(homeViewModel.slidesList.value?.slide.isNullOrEmpty())
        assert(homeViewModel.slidesStatus.value == ApiStatus.ERROR)

        assert(homeViewModel.newsList.value?.data.isNullOrEmpty())
        assert(homeViewModel.newsStatus.value == ApiStatus.ERROR)

        assert(homeViewModel.testimonialsList.value == testimonialsList)
        assert(homeViewModel.testimonialsList.value?.testimonials?.first()?.id == 466 )
        assert(homeViewModel.testimonialsStatus.value == ApiStatus.DONE)

        assert(homeViewModel.homeStatusLiveDataMerger.value == ApiStatus.ERROR)

    }
}