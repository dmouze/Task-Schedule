package com.dsw.pam.takschedule


import com.dsw.pam.takschedule.viewmodel.AdditionalViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { AdditionalViewModel() }
}
