package com.dsw.pam.takschedule.view
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dsw.pam.takschedule.intent.TaskIntent
import com.dsw.pam.takschedule.model.Task
import com.dsw.pam.takschedule.model.TaskState
import com.dsw.pam.takschedule.viewmodel.TaskViewModel

@Composable
fun TaskScreen(viewModel: TaskViewModel) {
    val taskState by viewModel.state.collectAsState()

    when (taskState) {
        is TaskState.Loading -> Text("Ładowanie zadań...")
        is TaskState.Error -> Text("Błąd: ${(taskState as TaskState.Error).message}")
        is TaskState.Loaded -> {
            val tasks = (taskState as TaskState.Loaded).tasks
            TaskList(tasks = tasks, onTaskToggled = { taskId, isCompleted ->
                viewModel.handleIntent(TaskIntent.ToggleTaskCompletion(taskId, isCompleted))
            })
        }
    }
}

@Composable
fun TaskList(tasks: List<Task>, onTaskToggled: (Int, Boolean) -> Unit) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(tasks) { task ->
            TaskItem(task = task, onCheckedChange = { isChecked ->
                onTaskToggled(task.id, isChecked)
            })
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

