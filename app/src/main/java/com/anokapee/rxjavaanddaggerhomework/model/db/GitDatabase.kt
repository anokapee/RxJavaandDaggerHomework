package com.anokapee.rxjavaanddaggerhomework.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.anokapee.rxjavaanddaggerhomework.model.data.GitCache
import com.anokapee.rxjavaanddaggerhomework.util.Constants.Companion.DATABASE_NAME

@Database(version = 1, entities = [GitCache::class])
abstract class GitDatabase: RoomDatabase() {

    abstract fun getDAO(): GitDao

    companion object{
        private lateinit var gitDatabase: GitDatabase

        fun initializeDatabase(context: Context){
            gitDatabase = Room.databaseBuilder(
                context,
                GitDatabase::class.java,
                DATABASE_NAME
            ).build()
        }

        fun getDao() = gitDatabase.getDAO()
    }
}