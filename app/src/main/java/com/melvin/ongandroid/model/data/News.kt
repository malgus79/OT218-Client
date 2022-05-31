package com.melvin.ongandroid.model.data

import com.google.gson.annotations.SerializedName

data class News(

    @SerializedName("data") val data: List<New>,
    @SerializedName("message") val message: String?,
    @SerializedName("success") val success: Boolean?
)
