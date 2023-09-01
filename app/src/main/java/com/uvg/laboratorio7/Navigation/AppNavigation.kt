package com.uvg.laboratorio7.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.uvg.laboratorio7.Screens.GaleryScreen
import com.uvg.laboratorio7.Screens.LoginScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val isLoggedIn = rememberSaveable { mutableStateOf(false) }

    NavHost(navController, startDestination = AppScreens.Login.route) {
        composable("login") {
            if (isLoggedIn.value) {
                GaleryScreen(navController = navController)
            } else {
                LoginScreen(onLoginSuccess = {
                    isLoggedIn.value = true
                    navController.navigate(AppScreens.Galery.route)
                })
            }
        }
        composable("gallery") {
            GaleryScreen(navController = navController)
        }
    }
}
