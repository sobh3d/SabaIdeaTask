package com.sobhan.sabaideatask.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
@Entity(tableName = "Pic")
data class Pic(
    @SerializedName("movie_img_s")
    @Expose
    @ColumnInfo(name = "movieImgS")
    val movieImgS: String,
    @SerializedName("movie_img_m")
    @Expose
    @ColumnInfo(name = "movieImgM")
    val movieImgM: String,
    @SerializedName("movie_img_b")
    @Expose
    @ColumnInfo(name = "movieImgB")
    val movieImgB: String
)
