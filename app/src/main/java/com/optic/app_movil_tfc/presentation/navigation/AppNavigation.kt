package com.optic.app_movil_tfc.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.optic.app_movil_tfc.presentation.screen.access.AccessScreen
import com.optic.app_movil_tfc.presentation.screen.preventiv.PreventivScreen
import com.optic.app_movil_tfc.presentation.screen.preventiv.PreventivViewModel

@Composable
fun AppNavigation(navController: NavHostController){
    NavHost(navController = navController,
        startDestination = AppScreen.Access.rute){
        composable(
            route = AppScreen.Access.rute
        ){
            AccessScreen(navController)
        }
        composable(
            route = AppScreen.Tasks.rute
        ){
            PreventivScreen()
        }
    }
}