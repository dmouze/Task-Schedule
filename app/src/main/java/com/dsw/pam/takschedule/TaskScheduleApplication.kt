package com.dsw.pam.takschedule

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TaskScheduleApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@TaskScheduleApplication)
            modules(appModule)
        }
    }
}
