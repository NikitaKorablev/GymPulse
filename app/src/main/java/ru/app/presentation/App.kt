package ru.app.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.app.presentation.screen.HomeScreen
import ru.app.presentation.viewmodel.HomeViewModel

@Composable
fun App() {
    val navController = rememberNavController()
    val viewModel = hiltViewModel<HomeViewModel>()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(viewModel.productDetailsState.collectAsState().value)
        }
    }
}