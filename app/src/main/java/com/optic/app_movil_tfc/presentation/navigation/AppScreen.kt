package com.optic.app_movil_tfc.presentation.navigation

sealed class AppScreen(val rute:String){
    object Access : AppScreen("access")
    object Tasks : AppScreen("tasks")
}
