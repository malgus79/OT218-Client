package com.melvin.ongandroid.model.data.slides

import com.google.gson.annotations.SerializedName

data class SlidesList(
    @SerializedName ("data") val slide: List<Slide>?,
    @SerializedName ("message") val message: String?,
    @SerializedName ("success") val success: Boolean?
)