package com.melvin.ongandroid.model.data.slides

import com.google.gson.annotations.SerializedName

data class Slide(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("image") val imageSlide: String?,
    @SerializedName("created_at") val createdAt: String?,
    @SerializedName("deleted_at") val deletedAt: Any?,
    @SerializedName("group_id") val groupId: Any?,
    @SerializedName("order") val order: Int?,
    @SerializedName("updated_at") val updatedAt: String?,
    @SerializedName("user_id") val userId: Any?
)