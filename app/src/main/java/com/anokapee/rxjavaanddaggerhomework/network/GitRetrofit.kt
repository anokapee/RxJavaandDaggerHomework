package com.anokapee.rxjavaanddaggerhomework.network

import com.anokapee.rxjavaanddaggerhomework.model.data.GitResponse
import com.anokapee.rxjavaanddaggerhomework.util.Constants.Companion.END_POINT
import com.anokapee.rxjavaanddaggerhomework.util.Constants.Companion.BASE_URL
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GitRetrofit @Inject constructor(){

    private val gitService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(GitService::class.java)

    fun getReposRemote() = gitService.getAllRepos()

    interface GitService{
        @GET(END_POINT)
        fun getAllRepos(): Single<GitResponse>
    }

}