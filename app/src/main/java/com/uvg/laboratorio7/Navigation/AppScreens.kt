package com.uvg.laboratorio7.Navigation

sealed class AppScreens(val route: String){
    object Login: AppScreens("Login_Screen")
    object Galery: AppScreens("Galery")
}
