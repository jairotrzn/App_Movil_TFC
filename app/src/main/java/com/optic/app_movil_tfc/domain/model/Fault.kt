package com.optic.app_movil_tfc.domain.model

import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.ktx.toObject

data class Fault(
    var id: String = "",
    var accessCode: String = "",
    var color: String = "",
    var end: String = "",
    var namePersonInCharge: String = "",
    var password: String = "",
    var start: String = "",
    var state: String = "",
    var student: String = "",
    var description :String = "",
    var solution :String = "",
    var machineCode: Machine? = null,



    ) {
    @get:Exclude
    @set:Exclude
    @Transient
    lateinit var documentReference: DocumentReference

    companion object {
        fun fromSnapshot(snapshot: DocumentSnapshot): Fault {
            val fault = snapshot.toObject<Fault>()!!
            fault.documentReference = snapshot.reference
            return fault
        }
    }
}