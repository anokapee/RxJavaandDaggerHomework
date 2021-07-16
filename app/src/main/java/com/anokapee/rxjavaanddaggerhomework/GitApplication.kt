package com.anokapee.rxjavaanddaggerhomework

import android.app.Application
import com.anokapee.rxjavaanddaggerhomework.di.component.DaggerGitComponent
import com.anokapee.rxjavaanddaggerhomework.model.db.GitDatabase
import com.anokapee.rxjavaanddaggerhomework.util.GitSingleton

class GitApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        GitDatabase.initializeDatabase(this)
        GitSingleton.gitComponent = DaggerGitComponent.create()
    }
}