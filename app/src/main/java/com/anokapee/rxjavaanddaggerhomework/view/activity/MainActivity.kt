package com.anokapee.rxjavaanddaggerhomework.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.anokapee.rxjavaanddaggerhomework.R

//Create an application to consume restful api data (https://api.github.com.users/{user_name}/repos)
// using RxJava for multithreading along with Retrofit.
//
//This project must be implemented in MVVM
//Must use Dagger2 for dependency injection
//Open details of RepoItem in a fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}