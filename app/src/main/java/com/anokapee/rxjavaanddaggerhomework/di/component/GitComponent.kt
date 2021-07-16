package com.anokapee.rxjavaanddaggerhomework.di.component

import com.anokapee.rxjavaanddaggerhomework.model.GitRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface GitComponent {
    fun getRepo(): GitRepository
}
