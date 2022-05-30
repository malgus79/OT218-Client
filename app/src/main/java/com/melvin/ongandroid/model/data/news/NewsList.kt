package com.melvin.ongandroid.model.data.news

import com.google.gson.annotations.SerializedName

data class NewsList(
    @SerializedName("data") val data: List<New>,
    @SerializedName("message") val message: String?,
<<<<<<< HEAD
<<<<<<< HEAD
    @SerializedName("success") val success: Boolean = false
=======
    @SerializedName("success") val success: Boolean?
>>>>>>> dd3c420 (Testimony fragment added)
=======
    @SerializedName("success") val success: Boolean?
>>>>>>> 5e4589c (Testimony fragment added)
)
