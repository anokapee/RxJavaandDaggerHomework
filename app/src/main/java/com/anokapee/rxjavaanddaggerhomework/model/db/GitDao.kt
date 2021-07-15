package com.anokapee.rxjavaanddaggerhomework.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.anokapee.rxjavaanddaggerhomework.model.data.GitCache
import com.anokapee.rxjavaanddaggerhomework.util.Constants.Companion.CACHE_KEY

@Dao
interface GitDao {

    @Insert(onConflict = REPLACE)
    fun cacheData(data: GitCache)

    @Query("SELECT * FROM git_cache WHERE cache_id = $CACHE_KEY")
    fun readFromCache(): GitCache
}