package com.example.test

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun TestScreen(navigateToMainScreen: () -> Unit) {
    Column {
        Text("Ekran z modułu Test")
        Button(onClick = { navigateToMainScreen() }) {
            Text("Powrót do głównego ekranu")
        }
    }
}
