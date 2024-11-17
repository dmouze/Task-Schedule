package com.dsw.pam.takschedule.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.test.TestScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "main_screen") {
        composable("main_screen") { MainScreen(navController) }
        composable("second_screen") { SecondScreen(navController) }
        composable("third_screen/{argument}") { backStackEntry ->
            val argument = backStackEntry.arguments?.getString("argument")
            ThirdScreen(argument = argument, navController = navController)
        }
        composable("additional_screen") {
            AdditionalScreen(navController)
        }
        composable("test_screen") { TestScreen({ navController.navigate("main_screen") }) }
    }
}