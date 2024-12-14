package com.dsw.pam.takschedule.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.dsw.pam.takschedule.model.Task
import com.dsw.pam.takschedule.viewmodel.TaskViewModel

@Composable
fun TaskScreen(navController: NavController) {
    val taskViewModel: TaskViewModel = viewModel()

    // Za pomocą collectAsState obserwujemy tasks w ViewModel
    val tasks = taskViewModel.tasks.collectAsState().value

    // Ładowanie danych (samo ładowanie tylko raz, po pierwszym renderowaniu kompozycji)
    LaunchedEffect(Unit) {
        taskViewModel.fetchTasks()
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Lista zadań", modifier = Modifier.padding(8.dp))

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(tasks) { task ->
                TaskItem(task)
            }
        }

        Spacer(modifier = Modifier.height(16.dp)) // Spacer między listą a przyciskiem

        Button(
            onClick = { taskViewModel.fetchTasks() }, // Kliknięcie przycisku załaduje nowe zadania
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Załaduj zadania")
        }
    }
}

@Composable
fun TaskItem(task: Task) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text("ID: ${task.id}")
        Text("Tytuł: ${task.title}")
        Text("Status: ${if (task.isCompleted) "Zakończono" else "Nie zakończono"}")
    }
}
