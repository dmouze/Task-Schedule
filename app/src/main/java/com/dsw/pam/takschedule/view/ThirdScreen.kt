package com.dsw.pam.takschedule.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun ThirdScreen(argument: String?, navController: NavController) {
    Column {
        Text("Trzeci ekran")
        Text("Argument: $argument")
        Button(onClick = { navController.popBackStack() }) {
            Text("Cofnij")
        }
    }
}
