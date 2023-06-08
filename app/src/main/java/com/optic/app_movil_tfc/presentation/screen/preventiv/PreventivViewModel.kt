package com.optic.app_movil_tfc.presentation.screen.preventiv

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.optic.app_movil_tfc.domain.model.Preventiv
import com.optic.app_movil_tfc.domain.use_case.preventiv.PreventivUseCase
import com.optic.gamermvvmapp.domain.model.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class PreventivViewModel @Inject constructor(
    private val preventivUseCase: PreventivUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    var preventivData: Preventiv? = null
    var preventivResponse by mutableStateOf<Response<Preventiv>?>(null)
    var updatePreventivResponse by mutableStateOf<Response<Boolean>?>(null)
        private set
    var accessCode = savedStateHandle.get<String>("accessCode")

    init {

        getPreventivByAccessCode()
    }

    private fun getPreventivByAccessCode() = viewModelScope.launch {
        preventivResponse = Response.Loading
        preventivUseCase.getPreventiv(accessCode.toString()).collect { response ->
            preventivResponse = response

        }
    }

    fun upDatePreventiv() {
        var preventiv = Preventiv(
            id = preventivData!!.id,
            accessCode = preventivData!!.accessCode,
            color = preventivData!!.color,
            end = preventivData!!.end,
            machineCode = preventivData!!.machineCode,
            namePersonInCharge = preventivData!!.namePersonInCharge,
            password = preventivData!!.password,
            start = preventivData!!.start,
            state = "Finalizado",
            tareas = ArrayList(preventivData!!.tareas.map { tarea ->
                tarea.copy(
                    lastDate = getCurrentDate(),
                    start = calculateNextDate(tarea.selectedFrencunce, getCurrentDate()),
                    end = calculateNextDate(tarea.selectedFrencunce, getCurrentDate()),
                    state = "Finalizada"
                )
            })
        )

        upDate(preventiv)
    }



    private fun upDate(preventiv: Preventiv) = viewModelScope.launch {

        updatePreventivResponse = Response.Loading
        preventivUseCase.updatePreventiv(preventiv).collect { response ->
            updatePreventivResponse = response
        }


    }

    fun getCurrentDate(): String {
        val date = Date()
        val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return format.format(date)
    }

    fun calculateNextDate(frecuencia: String, currentDate: String): String {
        val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val date = dateFormat.parse(currentDate) ?: return currentDate

        val calendar = Calendar.getInstance()
        calendar.time = date

        when (frecuencia) {
            "Diaria" -> calendar.add(Calendar.DAY_OF_MONTH, 1)
            "Semanal" -> calendar.add(Calendar.WEEK_OF_MONTH, 1)
            "Quincenal" -> calendar.add(Calendar.WEEK_OF_MONTH, 2)
            "Mensual" -> calendar.add(Calendar.MONTH, 1)
            else -> return currentDate
        }

        val nextDate = calendar.time
        return format.format(nextDate)
    }


}

