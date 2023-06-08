package com.optic.app_movil_tfc.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.optic.app_movil_tfc.presentation.screen.access.AccessScreen
import com.optic.app_movil_tfc.presentation.screen.fault.FaultScreen
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
            route = AppScreen.Preventiv.rute,
            arguments = listOf(navArgument("accessCode") {
              type = NavType.StringType
            })
        ) {
            it.arguments?.getString("accessCode")?.let {
                PreventivScreen(accessCode = it)
            }
        }

        composable(
            route = AppScreen.Fault.rute,
            arguments = listOf(navArgument("accessCode"){
                type = NavType.StringType
            })
        ){
            it.arguments?.getString("accessCode")?.let{
                //FaultScreen()
            }
        }
    }
}