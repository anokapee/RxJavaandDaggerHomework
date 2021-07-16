package com.anokapee.rxjavaanddaggerhomework.util

import com.anokapee.rxjavaanddaggerhomework.di.component.GitComponent

class GitSingleton {
    companion object{
        lateinit var gitComponent: GitComponent
    }
}