package com.dsw.pam.takschedule.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.dsw.pam.takschedule.viewmodel.AdditionalViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun AdditionalScreen(navController: NavController) {
    val viewModel: AdditionalViewModel = koinViewModel()
    val text = viewModel.screenText
    Column {
        Text("Ekran z modułu")
        Text("Dane z ViewModel: $text")
        Button(onClick = { navController.navigate("main_screen") }) {
            Text("Powrót do głównego ekranu")
        }
    }
}
