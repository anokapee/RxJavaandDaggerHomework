package com.anokapee.rxjavaanddaggerhomework.model

import com.anokapee.rxjavaanddaggerhomework.model.data.GitCache
import com.anokapee.rxjavaanddaggerhomework.model.data.GitResponse
import com.anokapee.rxjavaanddaggerhomework.model.db.GitDatabase.Companion.getDao
import com.anokapee.rxjavaanddaggerhomework.network.GitRetrofit
import com.anokapee.rxjavaanddaggerhomework.util.Constants.Companion.CACHE_KEY
import com.google.gson.Gson
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GitRepository @Inject constructor(private val gitRetrofit: GitRetrofit){

    fun readFromRemote(): Single<GitResponse> = gitRetrofit.getReposRemote()

    fun readFromCache(): GitResponse {
        val cache = getDao().readFromCache()
        val data = Gson().fromJson(cache.data, GitResponse::class.java)
        return data
    }

    fun saveToCache(response: GitResponse){
        val json = Gson().toJson(response)
        getDao().cacheData(GitCache(CACHE_KEY, json))
    }
}