package com.melvin.ongandroid.viewmodel


//Definition of states
sealed class State()  {
    class Success() : State()
    class Failure(val cause: Throwable) : State()
    class Loading() : State()
}