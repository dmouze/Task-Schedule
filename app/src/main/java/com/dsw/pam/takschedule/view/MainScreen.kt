package com.dsw.pam.takschedule.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun MainScreen(navController: NavController) {
    Column {
        Text("Ekran główny")
        Button(onClick = { navController.navigate("second_screen") }) {
            Text("Przejdź do drugiego ekranu")
        }
        Button(onClick = { navController.navigate("additional_screen") }) {
            Text("Przejdź do ekranu z modułu Additional")
        }
        Button(onClick = { navController.navigate("test_screen") }) {
            Text("Przejdź do ekranu z modułu Test")
        }
        Button(onClick = { navController.navigate("task_screen") }) {
            Text("Przejdź do Task Screen")
        }
    }
}
