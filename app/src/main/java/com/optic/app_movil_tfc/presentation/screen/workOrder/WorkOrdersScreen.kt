package com.optic.app_movil_tfc.presentation.screen.workOrder

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.optic.app_movil_tfc.presentation.screen.workOrder.components.GetFault
import com.optic.app_movil_tfc.presentation.screen.workOrder.components.GetPreventiv
import com.optic.app_movil_tfc.presentation.screen.workOrder.components.PreventivContent
import com.optic.app_movil_tfc.presentation.screen.workOrder.components.UpdateFault
import com.optic.app_movil_tfc.presentation.screen.workOrder.components.UpdatePreventiv


@Composable
fun PreventivScreen(
    viewModel: WorkOrderViewModel = hiltViewModel(),
    accessCode: String,
    ) {
    Scaffold(
        topBar = {},
        content = {
                  PreventivContent()
        },
        bottomBar = {}

    )
    GetPreventiv()
    GetFault()
    UpdatePreventiv()
    UpdateFault()
}

@Composable
fun BottomButton(onClick: () -> Unit) {
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
