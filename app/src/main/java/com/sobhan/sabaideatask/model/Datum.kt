package com.sobhan.sabaideatask.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
@Entity(tableName = "Datum")
data class Datum(

    @SerializedName("type")
    @Expose
    @ColumnInfo(name = "type")
    val type: String,

    @SerializedName("id")
    @Expose
    @ColumnInfo(name = "id")
    @PrimaryKey
    val id: Int,

    @SerializedName("attributes")
    @Expose
    @Embedded
    val attributes: Attributes
)
