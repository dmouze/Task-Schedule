package com.dsw.pam.takschedule.viewmodel.DI

import com.dsw.pam.takschedule.viewmodel.TaskViewModel
import com.dsw.pam.takschedule.viewmodel.network.TaskApiService
import com.dsw.pam.takschedule.viewmodel.network.TaskApiServiceImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<TaskApiService> { TaskApiServiceImpl(get()) }
    viewModel { TaskViewModel(get()) }
}