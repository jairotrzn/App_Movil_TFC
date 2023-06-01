package com.optic.app_movil_tfc.domain.model

import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.PropertyName
import com.google.firebase.firestore.ktx.toObject
import com.google.gson.Gson
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

data class Preventiv(
    @get:PropertyName("id")
    @set:PropertyName("id")
    var id: String = "",

    @get:PropertyName("accessCode")
    @set:PropertyName("accessCode")
    var accessCode: String = "",

    @get:PropertyName("color")
    @set:PropertyName("color")
    var color: String = "",

    @get:PropertyName("end")
    @set:PropertyName("end")
    var end: String = "",

    @get:PropertyName("namePersonInCharge")
    @set:PropertyName("namePersonInCharge")
    var namePersonInCharge: String = "",

    @get:PropertyName("password")
    @set:PropertyName("password")
    var password: String = "",

    @get:PropertyName("start")
    @set:PropertyName("start")
    var start: String = "",

    @get:PropertyName("state")
    @set:PropertyName("state")
    var state: String = "",

    @get:PropertyName("student")
    @set:PropertyName("student")
    var student: String = "",

    @get:PropertyName("tareas")
    @set:PropertyName("tareas")
    var tareas: ArrayList<Repuesto> = ArrayList(),

    @get:PropertyName("machineCode")
    @set:PropertyName("machineCode")
    var machineCode: Machine? = null,



    ) {
    @get:Exclude
    @set:Exclude
    @Transient
    lateinit var documentReference: DocumentReference

    companion object {
        fun fromSnapshot(snapshot: DocumentSnapshot): Preventiv {
            val preventiv = snapshot.toObject<Preventiv>()!!
            preventiv.documentReference = snapshot.reference
            return preventiv
        }
    }
}
