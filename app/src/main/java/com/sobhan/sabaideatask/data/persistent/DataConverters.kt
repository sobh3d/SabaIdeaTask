package com.sobhan.sabaideatask.data.persistent

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sobhan.sabaideatask.model.Pic

class DataConverters {
    @TypeConverter
    fun fromPic(value: Pic): String {
        val gson = Gson()
        val type = object : TypeToken<Pic>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toPic(value: String): Pic {
        val gson = Gson()
        val type = object : TypeToken<Pic>() {}.type
        return gson.fromJson(value, type)
    }
}