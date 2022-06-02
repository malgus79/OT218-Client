package com.melvin.ongandroid.model.data.testimonials

import com.google.gson.annotations.SerializedName

data class TestimonialsList(
    @SerializedName("success") val success: Boolean = false,
    @SerializedName("data") val testimonials: List<Testimonial>?,
    @SerializedName("message") val message: String?,
)
