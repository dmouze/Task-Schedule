package com.dsw.pam.takschedule.intent

sealed class TaskIntent {
    object LoadTasks : TaskIntent()
    data class ToggleTaskCompletion(val taskId: Int, val isCompleted: Boolean) : TaskIntent()
}