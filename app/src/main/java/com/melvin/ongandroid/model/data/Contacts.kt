package com.melvin.ongandroid.model.data

import com.google.gson.annotations.SerializedName

data class ContactDTO(
    val name: String,
    val email: String,
    val message: String,
)

data class Contact(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("phone")
    val phone: String?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("deleted_at")
    val deletedAt: String?,
    @SerializedName("created_at")
    val createdAt: String?,
    @SerializedName("updated_at")
    val updatedAt: String?
)

data class ContactResponse(
    val success: Boolean?,
    val data: Contact?,
    val message: String?,
)


