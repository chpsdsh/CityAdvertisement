package com.nsu.cityadvertisement.view

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun AppNavigator() {
    val navController  = rememberNavController();
    NavHost(navController, startDestination = "login"){
        composable("login") { }
        composable ("register") { }

    }

}
