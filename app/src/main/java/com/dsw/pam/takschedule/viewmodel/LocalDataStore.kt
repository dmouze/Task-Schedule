package com.dsw.pam.takschedule.viewmodel

interface LocalDataStore {
    fun saveTaskCount(count: Int)
    fun getTaskCount(): Int
}
