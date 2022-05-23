package com.melvin.ongandroid.model.data

import com.google.gson.annotations.SerializedName

data class HomeSlides(
    @SerializedName ("data") val listSlide: List<ListSlide>?,
    @SerializedName ("message") val message: String?,
    @SerializedName ("success") val success: Boolean?
)