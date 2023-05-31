package com.optic.app_movil_tfc.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DefaultButtom(
    text:String,
    onClick : () -> Unit,


){
    Button(
        modifier = Modifier.padding(start = 50.dp),
        onClick = { onClick()},
    ) {
        Text(text = text)
    }
}