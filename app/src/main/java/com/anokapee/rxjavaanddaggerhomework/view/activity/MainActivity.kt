package com.anokapee.rxjavaanddaggerhomework.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import com.anokapee.rxjavaanddaggerhomework.R
import com.anokapee.rxjavaanddaggerhomework.databinding.ActivityMainBinding
import com.anokapee.rxjavaanddaggerhomework.view.adapter.GitAdapter
import com.anokapee.rxjavaanddaggerhomework.view.fragment.GitFragment
import com.anokapee.rxjavaanddaggerhomework.viewmodel.GitViewModel

//Create an application to consume restful api data (https://api.github.com.users/{user_name}/repos)
// using RxJava for multithreading along with Retrofit.
//
//This project must be implemented in MVVM
//Must use Dagger2 for dependency injection
//Open details of RepoItem in a fragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainFrag: GitFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        mainFrag = supportFragmentManager.findFragmentById(R.id.main_frag) as GitFragment


    }
}