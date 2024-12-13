package com.dsw.pam.taskschedule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dsw.pam.takschedule.viewmodel.LocalDataStore
import kotlinx.coroutines.flow.MutableStateFlow
import com.dsw.pam.takschedule.viewmodel.TaskState
import com.dsw.pam.takschedule.viewmodel.TaskRepository
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class TaskViewModel(
    private val repository: TaskRepository,
    private val localDataStore: LocalDataStore
) : ViewModel() {

    private val _state = MutableStateFlow<TaskState>(TaskState.Loading)
    val state: StateFlow<TaskState> = _state

    init {
        loadTasks()
    }

    private fun loadTasks() {
        viewModelScope.launch {
            val tasks = repository.getTasks()
            val taskCount = tasks.size
            localDataStore.saveTaskCount(taskCount)
            _state.value = TaskState.Loaded(tasks)
        }
    }

    fun getSavedTaskCount(): Int {
        return localDataStore.getTaskCount()
    }
}