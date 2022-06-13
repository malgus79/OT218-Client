package com.melvin.ongandroid.model.data

import com.google.gson.annotations.SerializedName



data class LoginCredentials(
    @SerializedName("email")
    val email: String?,
    @SerializedName("password")
    val pass: String,
)

data class User(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("email_verified_at")
    val emailVerifiedAt: String?,
    @SerializedName("role_id")
    val roleId: Int?,
    @SerializedName("remember_token")
    val rememberToken: Boolean?,
    @SerializedName("created_at")
    val createdAt: String?,
    @SerializedName("updated_at")
    val updatedAt: String?,
    @SerializedName("deleted_at")
    val deletedAt: String?,
    @SerializedName("group_id")
    val groupId: Int?,
    @SerializedName("latitude")
    val latitude: Any?,
    @SerializedName("longitude")
    val longitude: Any?,
    @SerializedName("profile_image")
    val profileImage: String?,
)

data class LoginResponseData(
    @SerializedName("user")
    val user: User,
    @SerializedName("token")
    val token: String,
)

data class LoginResponse(
    @SerializedName("success") val success: Boolean = false,
    @SerializedName("data") val data: LoginResponseData,
    @SerializedName("message") val message: String?
)