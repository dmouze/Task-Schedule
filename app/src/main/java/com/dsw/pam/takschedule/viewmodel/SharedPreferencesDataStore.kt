package com.dsw.pam.takschedule.viewmodel

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesDataStore(context: Context) : LocalDataStore {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("task_schedule_prefs", Context.MODE_PRIVATE)

    override fun saveTaskCount(count: Int) {
        sharedPreferences.edit()
            .putInt("task_count", count)
            .apply()
    }

    override fun getTaskCount(): Int {
        return sharedPreferences.getInt("task_count", 0)
    }
}
