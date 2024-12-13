package com.dsw.pam.takschedule.viewmodel

import com.dsw.pam.takschedule.model.Task

class TaskRepository {
    fun getTasks(): List<Task> {
        return listOf(
            Task(id = 1, title = "Zadanie 1"),
            Task(id = 2, title = "Zadanie 2"),
            Task(id = 3, title = "Zadanie 3")
        )
    }
}
