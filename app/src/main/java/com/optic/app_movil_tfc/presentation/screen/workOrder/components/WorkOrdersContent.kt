package com.optic.app_movil_tfc.presentation.screen.workOrder.components

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.optic.app_movil_tfc.R
import com.optic.app_movil_tfc.domain.model.Fault
import com.optic.app_movil_tfc.domain.model.Preventiv
import com.optic.app_movil_tfc.presentation.screen.workOrder.WorkOrderViewModel
import java.time.format.TextStyle

@Composable
fun PreventivContent(
    navHostController: NavHostController,
    viewModel: WorkOrderViewModel = hiltViewModel()) {
    Box(
        modifier = Modifier.padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        if (viewModel.preventivData.accessCode != "") {
            if(viewModel.preventivData.state != "Finalizado"){
                PreventivSection(viewModel)
            }else{
                FinisLogp()
            }

        } else if (viewModel.faultData.accessCode != "") {
            if(viewModel.faultData.state != "Finalizado"){
                FaultSection(viewModel)
            }else{
                FinisLogp()
            }

        } else {
            //navHostController.popBackStack()
            //navHostController.navigate("access")
        }
    }
}

@Composable
fun PreventivSection(viewModel: WorkOrderViewModel) {
    Column(modifier = Modifier.padding(5.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        InputPreventivSection(viewModel)
        CardList(viewModel)

    }

}

@Composable
fun FaultSection(viewModel: WorkOrderViewModel) {

    Column(modifier = Modifier.padding(5.dp), horizontalAlignment = Alignment.CenterHorizontally) {

        InputFaultSection(viewModel)


    }
}

@Composable
fun InputFaultSection(viewModel: WorkOrderViewModel) {
    val fault: Fault = viewModel.faultData
    Column(modifier = Modifier.padding(5.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            modifier = Modifier.padding(10.dp),
            value = fault.namePersonInCharge,
            onValueChange = { },
            label = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "",
                        modifier = Modifier.padding(end = 4.dp)
                    )
                    Text(text = "Responsable")
                }
            },
            enabled = false
        )

        OutlinedTextField(
            modifier = Modifier.padding(5.dp),
            value = fault.student,
            onValueChange = { },
            label = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Face,
                        contentDescription = "",
                        modifier = Modifier.padding(end = 4.dp)
                    )
                    Text(text = "Alumno")
                }
            },
            enabled = false
        )

        OutlinedTextField(
            modifier = Modifier.padding(5.dp),
            value = fault.description,
            onValueChange = { },
            label = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "",
                        modifier = Modifier.padding(end = 4.dp)
                    )
                    Text(text = "Descripción de averia ")
                }
            },
            enabled = false
        )

        OutlinedTextField(
            modifier = Modifier.padding(10.dp),
            value = viewModel.state.solution,
            onValueChange = { viewModel.solutionChange(it) },
            label = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Build,
                        contentDescription = "",
                        modifier = Modifier.padding(end = 4.dp)
                    )
                    Text(text = "Solución averia")
                }
            }
        )
    }
}

@Composable
fun InputPreventivSection(viewModel: WorkOrderViewModel) {
    val preventiv: Preventiv = viewModel.preventivData
    Column(modifier = Modifier.padding(5.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            modifier = Modifier.padding(10.dp),
            value = preventiv.namePersonInCharge,
            onValueChange = { },
            label = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "",
                        modifier = Modifier.padding(end = 4.dp)
                    )
                    Text(text = "Responsable")
                }
            },
            enabled = false
        )

        OutlinedTextField(
            modifier = Modifier.padding(5.dp),
            value = preventiv.student,
            onValueChange = { },
            label = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Face,
                        contentDescription = "",
                        modifier = Modifier.padding(end = 4.dp)
                    )
                    Text(text = "Alumno")
                }
            },
            enabled = false
        )
    }
}

@Composable
fun CardList(viewModel: WorkOrderViewModel) {
    val preventiv: Preventiv = viewModel.preventivData

    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)) {
        items(
            items = preventiv.tareas
        ) { Task ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                elevation = 4.dp,
                content = {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = Task.name,
                            style = MaterialTheme.typography.h5,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.End
                        )
                        Text(
                            fontWeight = FontWeight.Bold,
                            text = "Procedimiento"
                        )
                        Task.datos.forEach { dato ->
                            Text(text = "  - $dato")
                        }
                        Text(
                            fontWeight = FontWeight.Bold,
                            text = "Repuestos:"
                        )
                        Task.repuestos.forEachIndexed { index, repuesto ->
                            Text(text = "    ID de repuesto: ${repuesto.idRepuesto}")
                            Text(text = "    Nombre: ${repuesto.name}")
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    }
                }
            )
        }
    }
}

@Composable
fun FinisLogp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth(),
            painter = painterResource(id = R.drawable.finish_logo),
            contentDescription = "Logo",
        )

        Text(
            text = "Esta orden ha finalizado con éxito",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}
