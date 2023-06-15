package com.optic.app_movil_tfc.domain.model

import com.google.gson.Gson
import java.util.Date

data class Fault(
    var id: String = "",
    var accessCode: String = "",
    var color: String = "",
    var end: Date = Date(),
    var namePersonInCharge: String = "",
    var password: String = "",
    var start: Date = Date(),
    var state: String = "",
    var student: String = "",
    var description: String = "",
    var solution: String = "",
    var machineCode: Machine? = null,
    var name: String = "",
    var finish: Boolean = false


) {
    fun toJson(): String = Gson().toJson(
        Fault(
            id,
            accessCode,
            color,
            end,
            namePersonInCharge,
            password,
            start,
            state,
            student,
            description,
            solution,
            machineCode,
            name,
            finish
        )
    )

    companion object {
      fun fromJson(data:String):Fault = Gson().fromJson(data,Fault::class.java)
    }
}