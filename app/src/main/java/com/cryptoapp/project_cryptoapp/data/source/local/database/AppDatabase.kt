package com.cryptoapp.project_cryptoapp.data.source.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cryptoapp.project_cryptoapp.data.source.local.database.dao.FavoriteDao
import com.cryptoapp.project_cryptoapp.data.source.local.database.entity.FavoriteEntity

@Database(
    entities = [FavoriteEntity::class],
    version = 1,
    exportSchema = false,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao

    companion object {
        private const val DB_NAME = "crypto.db"

        fun createInstance(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                DB_NAME,
            ).fallbackToDestructiveMigration().build()
        }
    }
}
