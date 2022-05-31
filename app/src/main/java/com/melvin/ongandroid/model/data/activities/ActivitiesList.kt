package com.melvin.ongandroid.model.data.activities

import com.google.gson.annotations.SerializedName

data class ActivitiesList(
    @SerializedName("success") val success: Boolean?,
    @SerializedName("data") val data: List<Activities>?,
    @SerializedName("message") val message: String?,
)
