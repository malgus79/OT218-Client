package com.melvin.ongandroid.viewmodel

import com.melvin.ongandroid.model.data.slides.SlidesList


//Definition of states
sealed class State<T>()  {

    class Success<T>(val data: T) : State<T>()
    class Failure<T>(val cause: Throwable) : State<T>()
    class Loading<T>() : State<T>()
}