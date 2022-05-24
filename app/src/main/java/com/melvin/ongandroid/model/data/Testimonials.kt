package com.melvin.ongandroid.model.data

import com.google.gson.annotations.SerializedName

data class Testimonials(
    @SerializedName("success") val success: Boolean,
    @SerializedName("data") val testimonialsList: List<Testimony>?,
    @SerializedName("message") val message: String?,
)
