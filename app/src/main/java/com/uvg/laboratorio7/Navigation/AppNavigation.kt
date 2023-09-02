package com.uvg.laboratorio7.Navigation

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.uvg.laboratorio7.Screens.GaleryScreen
import com.uvg.laboratorio7.Screens.LoginScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val isLoggedIn = rememberSaveable { mutableStateOf(false) }
    val closingSession = rememberSaveable { mutableStateOf(false) }

    NavHost(navController, startDestination = AppScreens.Login.route) {
        composable("Login_Screen") {
            if (isLoggedIn.value) {
                GaleryScreen(navController = navController, onLogout = {
                    isLoggedIn.value = false
                    navController.navigate(AppScreens.Login.route)
                })
            } else {
                LoginScreen(onLoginSuccess = {
                    isLoggedIn.value = true
                    navController.navigate(AppScreens.Galery.route)
                })
            }
        }
        composable("Galery") {
            GaleryScreen(navController = navController, onLogout = {
                isLoggedIn.value = false
                closingSession.value = true
                navController.navigate(AppScreens.Login.route)
            })
        }
    }
    if (closingSession.value) {
        Toast.makeText( LocalContext.current , "Cerrando sesion...", Toast.LENGTH_SHORT).show()
        closingSession.value = false
    }
}
