package com.melvin.ongandroid.model

import com.google.gson.annotations.SerializedName


data class NewResponse(

    @SerializedName("data") val listSlide: List<News>?,
    @SerializedName("message") val message: String?,
    @SerializedName("success") val success: Boolean?
)
