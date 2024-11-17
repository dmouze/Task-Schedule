package com.dsw.pam.taskschedule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.dsw.pam.takschedule.model.Task

class TaskViewModel : ViewModel() {

    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> = _tasks

    init {
        // Przykładowe zadania
        _tasks.value = listOf(
            Task(1, "Zadanie 1"),
            Task(2, "Zadanie 2"),
            Task(3, "Zadanie 3")
        )
    }

    // Funkcja do aktualizacji stanu ukończenia zadania
    fun updateTaskCompletion(taskId: Int, isCompleted: Boolean) {
        viewModelScope.launch {
            _tasks.value = _tasks.value.map {
                if (it.id == taskId) {
                    it.copy(isCompleted = isCompleted)
                } else {
                    it
                }
            }
        }
    }

    // Funkcja do dodawania nowego zadania
    fun addTask(title: String) {
        val newTask = Task(id = _tasks.value.size + 1, title = title)
        viewModelScope.launch {
            _tasks.value = _tasks.value + newTask
        }
    }
}
