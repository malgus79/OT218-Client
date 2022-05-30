package com.melvin.ongandroid.model.data.activities

import com.google.gson.annotations.SerializedName
import com.melvin.ongandroid.model.data.news.New

data class ActivitiesList(
    @SerializedName("success") val success: Boolean?,
    @SerializedName("data") val data: List<Activities>?,
    @SerializedName("message") val message: String?
)
