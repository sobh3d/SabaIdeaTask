package com.sobhan.sabaideatask.data.persistent

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sobhan.sabaideatask.model.Datum

@Database(
    entities = [Datum::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(DataConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao

    companion object {
        private const val DATABASE_NAME: String = "Movie"

        @Volatile
        private var DB_INSTANCE: AppDatabase? = null

        fun getAppDataBase(context: Context): AppDatabase {
            if (DB_INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    if (DB_INSTANCE == null) {
                        DB_INSTANCE =
                            Room
                                .databaseBuilder(
                                    context.applicationContext,
                                    AppDatabase::class.java,
                                    DATABASE_NAME
                                )
                                .fallbackToDestructiveMigration()
                                .build()
                    }
                }
            }
            return DB_INSTANCE!!
        }
    }
}