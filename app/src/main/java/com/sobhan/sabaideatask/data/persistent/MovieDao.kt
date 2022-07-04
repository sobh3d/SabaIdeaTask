package com.sobhan.sabaideatask.data.persistent

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.sobhan.sabaideatask.model.Datum

@Dao
interface MovieDao : BaseDao<Datum>  {


    @Query("SELECT * FROM Datum")
    suspend fun getAllInstantly(): List<Datum>

    @Query("DELETE FROM Datum")
    suspend fun clear()


    @Transaction
    suspend fun dropAndInsertAllMessage(messages: List<Datum>) {
        clear()
        insertAll(messages)
    }
}