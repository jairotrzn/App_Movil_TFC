package com.optic.app_movil_tfc.domain.model

import Task
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.PropertyName
import com.google.firebase.firestore.ktx.toObject
import com.google.gson.Gson
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

data class Preventiv(

    var id: String = "",
    var accessCode: String = "",
    var color: String = "",
    var end: String = "",
    var namePersonInCharge: String = "",
    var password: String = "",
    var start: String = "",
    var state: String = "",
    var student: String = "",
    var machineCode: Machine? = null,
    var tareas: ArrayList<Task> = ArrayList(),
    var name:String = "",

    ) {

    fun toJson(): String = Gson().toJson(
        Preventiv(
            id,
            accessCode,
            color,
            end,
            namePersonInCharge,
            password,
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