package com.optic.app_movil_tfc.presentation.navigation

sealed class AppScreen(val rute:String){
    object Access : AppScreen("access")
    object Preventiv : AppScreen("preventivs/{accessCode}"){
        fun createRoute(accessCode : String) = "preventivs /$accessCode"
    }
    object Fault : AppScreen("fault/{accessCode}"){
        fun createRoute(accessCode : String) = "tasks/$accessCode"
    }
    object Prueba : AppScreen("prueba/{accessCode}"){
        fun createRoute(accessCode : String) = "prueba/$accessCode"
    }
}
