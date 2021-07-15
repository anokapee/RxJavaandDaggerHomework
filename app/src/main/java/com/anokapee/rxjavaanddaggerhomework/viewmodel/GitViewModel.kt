package com.anokapee.rxjavaanddaggerhomework.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anokapee.rxjavaanddaggerhomework.model.GitRepository
import com.anokapee.rxjavaanddaggerhomework.model.data.GitResponseItem
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class GitViewModel: ViewModel() {

    val gitData = MutableLiveData<List<GitResponseItem>>()
    private val repo = GitRepository()
    private val compDisposable = CompositeDisposable()

    init {
        compDisposable.add(
            repo.readFromRemote()
                .observeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .map { gitRes ->
                    Log.d("TAG_X", "saving to cache - on ${Thread.currentThread().name}")
                    repo.saveToCache(gitRes)
                    gitRes
                }
                .subscribe({ gitResponse ->
                    Log.d("TAG_X", "update LiveData on ${Thread.currentThread().name}")
                    gitData.postValue(gitResponse)
                },{ throwable ->
                    Log.d("TAG_X", "Oops: ${throwable.localizedMessage}")
                    Log.d("TAG_X", "Reading from cache")
                    gitData.postValue(repo.readFromCache())
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compDisposable.clear()
    }
}