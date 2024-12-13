package com.dsw.pam.takschedule.viewmodel.DI

import com.dsw.pam.takschedule.viewmodel.LocalDataStore
import com.dsw.pam.takschedule.viewmodel.SharedPreferencesDataStore
import com.dsw.pam.takschedule.viewmodel.TaskRepository
import com.dsw.pam.taskschedule.TaskViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {
    single<LocalDataStore> { SharedPreferencesDataStore(get()) } // Wstrzyknięcie implementacji magazynu
    single { TaskRepository() }
    viewModel { TaskViewModel(get(), get()) }
}
