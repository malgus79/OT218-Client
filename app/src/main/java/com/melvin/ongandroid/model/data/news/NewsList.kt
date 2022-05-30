package com.melvin.ongandroid.model.data.news

import com.google.gson.annotations.SerializedName

data class NewsList(
    @SerializedName("data") val data: List<New>,
    @SerializedName("message") val message: String?,
<<<<<<< HEAD
    @SerializedName("success") val success: Boolean = false
=======
    @SerializedName("success") val success: Boolean?
>>>>>>> dd3c420 (Testimony fragment added)
)
