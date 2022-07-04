package com.sobhan.sabaideatask.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.sobhan.sabaideatask.model.Datum

data class MovieResponseWrapper(
    @SerializedName("data")
    @Expose
    val data: List<Datum>
)
