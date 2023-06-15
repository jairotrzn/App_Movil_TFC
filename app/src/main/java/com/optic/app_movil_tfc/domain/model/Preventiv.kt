package com.optic.app_movil_tfc.domain.model

import Task
import com.google.gson.Gson
import java.util.Date

data class Preventiv(

    var id: String = "",
    var accessCode: String = "",
    var color: String = "",
    var end: Date = Date(),
    var namePersonInCharge: String = "",
    var finish: Boolean = false,
    var start: Date = Date(),
    var state: String = "",
    var student: String = "",
    var machineCode: Machine? = null,
    var tareas: List<Task> = emptyList(),
    var name:String = "",

    ) {

    fun toJson(): String = Gson().toJson(
        Preventiv(
            id,
            accessCode,
            color,
            end,
            namePersonInCharge,
            finish,
            start,
            state,
            student,
            machineCode,
            tareas,
            name
        )
    )

    companion object {
        fun fromJson(data: String): Preventiv = Gson().fromJson(data, Preventiv::class.java)
    }
}