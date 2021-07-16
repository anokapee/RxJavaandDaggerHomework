package com.anokapee.rxjavaanddaggerhomework

import android.app.Application
import com.anokapee.rxjavaanddaggerhomework.model.db.GitDatabase

class GitApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        GitDatabase.initializeDatabase(this)
    }
}