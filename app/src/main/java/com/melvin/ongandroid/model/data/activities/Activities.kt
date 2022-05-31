package com.melvin.ongandroid.model.data.activities

import com.google.gson.annotations.SerializedName



class Activity (
    @SerializedName("id")
    val id : Int?,

    @SerializedName("name")
    val name : String?,

    @SerializedName("slug")
    val slug : String?,

    @SerializedName("description")
    val description : String?,

    @SerializedName("image")
    val image : String?,

    @SerializedName("user_id")
    val user_id : Int?,

    @SerializedName("category_id")
    val category_id : Int?,

    @SerializedName("created_at")
    val created_at : String?,

    @SerializedName("updated_at")
    val updated_at : String?,

    @SerializedName("deleted_at")
    val deleted_at : String?
)

data class ActivitiesList(
    @SerializedName("success") val success: Boolean = false,
    @SerializedName("data") val data: List<Activity>?,
    @SerializedName("message") val message: String?
)
