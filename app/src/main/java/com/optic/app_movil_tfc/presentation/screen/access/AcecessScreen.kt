package com.optic.app_movil_tfc.presentation.screen.access

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.optic.app_movil_tfc.presentation.screen.access.components.AccessContent

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview(showBackground = true, showSystemUi = true)
fun AccessScreen() {
    Scaffold(
        topBar = {},
        content = {
            AccessContent()
        },
        bottomBar = {}
    )
}
