package com.dsw.pam.takschedule.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dsw.pam.takschedule.model.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TaskViewModel : ViewModel() {

    private val _tasks = MutableStateFlow(
        listOf(
            Task(id = 1, title = "Zadanie 1"),
            Task(id = 2, title = "Zadanie 2"),
            Task(id = 3, title = "Zadanie 3")
        )
    )
    val tasks: StateFlow<List<Task>> = _tasks

    fun updateTaskCompletion(taskId: Int, isCompleted: Boolean) {
        viewModelScope.launch {
            _tasks.value = _tasks.value.map { task ->
                if (task.id == taskId) task.copy(isCompleted = isCompleted) else task
            }
        }
    }
}
