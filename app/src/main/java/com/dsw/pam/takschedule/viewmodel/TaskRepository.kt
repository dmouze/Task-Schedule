package com.dsw.pam.takschedule.viewmodel

import com.dsw.pam.takschedule.model.Task
import com.dsw.pam.takschedule.viewmodel.network.TaskApiService

class TaskRepository(private val apiService: TaskApiService) {

    // Pobierz zadania
    suspend fun fetchTasks(): List<Task> = apiService.getTasks()

    // Utwórz nowe zadanie
    suspend fun createTask(task: Task): Task = apiService.createTask(task)
}
