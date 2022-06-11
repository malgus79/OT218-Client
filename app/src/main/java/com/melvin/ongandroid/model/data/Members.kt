package com.melvin.ongandroid.model.data

import com.google.gson.annotations.SerializedName


data class Member(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("facebookUrl")
    val facebookUrl: String?,
    @SerializedName("linkedinUrl")
    val linkedinUrl: String?,
    @SerializedName("created_at")
    val createdAt: String?,
    @SerializedName("updated_at")
    val updatedAt: String?,
    @SerializedName("deleted_at")
    val deletedAt: String?
)

data class MembersList(
    @SerializedName("success") val success: Boolean = false,
    @SerializedName("data") val data: List<Member>?,
    @SerializedName("message") val message: String?,

)
