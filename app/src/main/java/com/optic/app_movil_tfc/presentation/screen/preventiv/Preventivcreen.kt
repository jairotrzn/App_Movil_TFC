package com.optic.app_movil_tfc.presentation.screen.preventiv

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TaskScreen(navController : NavHostController){
    Scaffold(
        topBar = {},
        content = {
                  Text(text = "Segunda pantalla")
        },
        bottomBar = {}
    )
}