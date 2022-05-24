package com.melvin.ongandroid.model.data

import com.google.gson.annotations.SerializedName

data class NewResponse(

    @SerializedName("data") val data: List<News>,
    @SerializedName("message") val message: String?,
    @SerializedName("success") val success: Boolean?
)
