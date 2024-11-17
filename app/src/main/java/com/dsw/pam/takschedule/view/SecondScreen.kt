package com.dsw.pam.takschedule.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun SecondScreen(navController: NavController) {
    Column {
        Text("Drugi ekran")
        Button(onClick = { navController.navigate("third_screen/PrzykładowyArgument") }) {
            Text("Przejdź do trzeciego ekranu z argumentem")
        }
        Button(onClick = { navController.popBackStack() }) {
            Text("Cofnij")
        }
    }
}
