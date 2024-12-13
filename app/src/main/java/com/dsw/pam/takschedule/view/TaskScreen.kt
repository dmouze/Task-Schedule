package com.dsw.pam.takschedule.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dsw.pam.takschedule.model.Task
import com.dsw.pam.takschedule.viewmodel.TaskState
import com.dsw.pam.taskschedule.TaskViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun TaskScreen(navController: NavController, viewModel: TaskViewModel = koinViewModel()) {
    val taskState by viewModel.state.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Lista zadań", style = MaterialTheme.typography.headlineMedium)

        when (taskState) {
            is TaskState.Loading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
            }
            is TaskState.Loaded -> {
                val tasks = (taskState as TaskState.Loaded).tasks
                LazyColumn {
                    items(tasks) { task ->
                        TaskItem(task = task)
                    }
                }
                Text("Ilość zapisanych zadań: ${viewModel.getSavedTaskCount()}")
            }
            is TaskState.Error -> {
                val error = taskState as TaskState.Error
                Text("Wystąpił błąd: ${error.message}", color = MaterialTheme.colorScheme.error)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("main_screen") }) {
            Text("Wróć do ekranu głównego")
        }
    }
}

@Composable
fun TaskItem(task: Task) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = task.title, style = MaterialTheme.typography.bodyLarge)
        }
    }
}
