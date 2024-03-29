package com.optic.app_movil_tfc.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.optic.app_movil_tfc.presentation.screen.Prueba.PruebaScreen
import com.optic.app_movil_tfc.presentation.screen.access.AccessScreen
import com.optic.app_movil_tfc.presentation.screen.workOrder.PreventivScreen

@Composable
fun AppNavigation(

    navController: NavHostController){
    NavHost(navController = navController,
        startDestination = AppScreen.Access.rute){
        composable(
            route = AppScreen.Access.rute
        ){
            AccessScreen(navController = navController)
        }
        composable(
            route = AppScreen.Preventiv.rute,
            arguments = listOf(navArgument("accessCode") {
              type = NavType.StringType
            })
        ) {
            it.arguments?.getString("accessCode")?.let {
                PreventivScreen(navHostController = navController,accessCode = it)
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
        composable(
            route = AppScreen.Prueba.rute,
            arguments = listOf(navArgument("accessCode"){
                type = NavType.StringType
            })
        ){
            it.arguments?.getString("accessCode")?.let{
               PruebaScreen(acessCode = it)
            }
        }
    }
}