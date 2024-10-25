package com.dsw.pam.takschedule.model

sealed class TaskState {
    object Loading : TaskState()
    data class Loaded(val tasks: List<Task>) : TaskState()
    data class Error(val message: String) : TaskState()
}