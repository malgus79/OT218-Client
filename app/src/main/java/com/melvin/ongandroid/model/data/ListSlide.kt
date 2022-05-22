package com.melvin.ongandroid.model.data

import com.google.gson.annotations.SerializedName

data class ListSlide(
    @SerializedName("created_at") val createdAt: String?,
    @SerializedName("deleted_at") val deletedAt: Any?,
    @SerializedName("description") val description: String?,
    @SerializedName("group_id") val groupId: Any?,
    @SerializedName("id") val id: Int?,
    @SerializedName("image") val imageSlide: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("order") val order: Int?,
    @SerializedName("updated_at") val updatedAt: String?,
    @SerializedName("user_id") val userId: Any?
)