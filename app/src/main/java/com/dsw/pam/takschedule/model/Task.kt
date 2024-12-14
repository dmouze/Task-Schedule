package com.dsw.pam.takschedule.model

data class Task(
    val id: Int = 0,
    val title: String,
    var isCompleted: Boolean = false
)

