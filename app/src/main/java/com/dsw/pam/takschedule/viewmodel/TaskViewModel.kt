package com.dsw.pam.takschedule.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.dsw.pam.takschedule.model.Task
import com.dsw.pam.takschedule.viewmodel.network.TaskApiService


class TaskViewModel(private val taskRepository: TaskRepository) : ViewModel() {

    // Inicjalizacja listy zadań
    val tasks = mutableListOf<Task>()

    // Pobierz zadania
    fun fetchTasks() {
        viewModelScope.launch {
            tasks.clear()
            tasks.addAll(taskRepository.fetchTasks())
        }
    }

    // Dodaj nowe zadanie
    fun addTask(task: Task) {
        viewModelScope.launch {
            val newTask = taskRepository.createTask(task)
            tasks.add(newTask) // Dodaj nowe zadanie do listy
        }
    }
}