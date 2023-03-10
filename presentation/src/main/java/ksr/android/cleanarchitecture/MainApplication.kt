package ksr.android.cleanarchitecture

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : Application() {
    companion object {
        lateinit var INSTANCE: MainApplication
        lateinit var applicationCtx: Context
    }

    init {
        INSTANCE = this
    }

    override fun onCreate() {
        super.onCreate()
        applicationCtx = applicationContext
    }
}