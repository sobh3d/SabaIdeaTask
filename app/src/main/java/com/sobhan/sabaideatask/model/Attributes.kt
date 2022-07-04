package com.sobhan.sabaideatask.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Attributes(
    @SerializedName("movie_title_en")
    @Expose
    @ColumnInfo(name = "movieTitleEn")
    val movieTitleEn:  String ,

    @SerializedName("rate_avrage")
    @Expose
    @ColumnInfo(name = "rate_avrage")
    val rate_avrage:  String ,

    @SerializedName("pic")
    @Expose
    @ColumnInfo(name = "pic")
    val pic: Pic

)
