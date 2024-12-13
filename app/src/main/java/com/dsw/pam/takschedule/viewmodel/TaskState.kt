package com.dsw.pam.takschedule.viewmodel

import com.dsw.pam.takschedule.model.Task

sealed class TaskState {
    object Loading : TaskState()
    data class Loaded(val tasks: List<Task>) : TaskState()
    data class Error(val message: String) : TaskState()
}