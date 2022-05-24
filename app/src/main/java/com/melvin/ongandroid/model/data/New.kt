package com.melvin.ongandroid.model.data

import com.google.gson.annotations.SerializedName



data class New(
    @SerializedName("id")
    val id : Int?,

    @SerializedName("name")
    val name : String?,

    @SerializedName("slug")
    val slug : String?,

    @SerializedName("content")
    val content : String?,

    @SerializedName("image")
    val image : String?,

    @SerializedName("user_id")
    val user_id : Int?,

    @SerializedName("category_id")
    val category_id : Int?,

    @SerializedName("created_at")
    val created_at : String,

    @SerializedName("updated_at")
    val updated_at : String,

    @SerializedName("deleted_at")
    val deleted_at : String = ""

)
