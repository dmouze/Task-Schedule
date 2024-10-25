package com.dsw.pam.takschedule.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dsw.pam.takschedule.model.Task
import com.dsw.pam.takschedule.viewmodel.TaskViewModel

@Composable
fun TaskScreen(viewModel: TaskViewModel) {
    val taskList by viewModel.tasks.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Lista Zadań", style = MaterialTheme.typography.titleLarge)

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(taskList) { task ->
                TaskItem(task = task, onCheckedChange = { isChecked ->
                    viewModel.updateTaskCompletion(task.id, isChecked)
                })
            }
        }
    }
}

@Composable
fun TaskItem(task: Task, onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = task.isCompleted,
            onCheckedChange = onCheckedChange
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = task.title,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
