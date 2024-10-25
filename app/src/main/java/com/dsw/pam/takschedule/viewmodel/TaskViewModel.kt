package com.dsw.pam.takschedule.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dsw.pam.takschedule.intent.TaskIntent
import com.dsw.pam.takschedule.model.Task
import com.dsw.pam.takschedule.model.TaskState
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class TaskViewModel : ViewModel() {
    private val _state = MutableStateFlow<TaskState>(TaskState.Loading)
    val state: StateFlow<TaskState> = _state.asStateFlow()

    init {
        handleIntent(TaskIntent.LoadTasks)
    }

    fun handleIntent(intent: TaskIntent) {
        viewModelScope.launch {
            when (intent) {
                is TaskIntent.LoadTasks -> loadTasks()
                is TaskIntent.ToggleTaskCompletion -> updateTaskCompletion(intent.taskId, intent.isCompleted)
            }
        }
    }

    private fun loadTasks() {
        _state.value = TaskState.Loaded(
            listOf(
                Task(id = 1, title = "Zadanie 1"),
                Task(id = 2, title = "Zadanie 2"),
                Task(id = 3, title = "Zadanie 3")
            )
        )
    }

    private fun updateTaskCompletion(taskId: Int, isCompleted: Boolean) {
        val currentState = _state.value
        if (currentState is TaskState.Loaded) {
            _state.value = TaskState.Loaded(
                tasks = currentState.tasks.map { task ->
                    if (task.id == taskId) task.copy(isCompleted = isCompleted) else task
                }
            )
        }
    }
}
