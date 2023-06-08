package com.optic.app_movil_tfc.presentation.screen.fault

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.optic.app_movil_tfc.presentation.screen.fault.components.GetFault

@Composable
fun FaultScreen (
    viewModel: FaultViewModel = hiltViewModel(),
    acessCode: String
){
    Scaffold(
        topBar = {},
        content = {
                  GetFault()
        },
        bottomBar = {  Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            com.optic.app_movil_tfc.presentation.screen.preventiv.CustomFloatingActionButton(
                onClick = {viewModel.updateFault()}
            )
        }
        }
    )


}
@Composable
fun CustomFloatingActionButton(
    onClick: () -> Unit
) {
    FloatingActionButton(
        onClick = onClick,
        backgroundColor = Color(0xFF64B5F6), // Color azul claro
        shape = CircleShape,
        modifier = Modifier.padding(16.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Check,
            contentDescription = "Guardar",
            tint = Color.White
        )
    }
}

