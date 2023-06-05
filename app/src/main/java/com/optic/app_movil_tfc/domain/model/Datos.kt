package com.optic.app_movil_tfc.domain.model

import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.PropertyName
import com.google.firebase.firestore.ktx.toObject

data class Datos(

    @get:PropertyName("department")
    @set:PropertyName("department")
    var department: String = "",

    @get:PropertyName("id")
    @set:PropertyName("id")
    var id: String = "",

    @get:PropertyName("location")
    @set:PropertyName("location")
    var location: String = "",

    @get:PropertyName("machineCode")
    @set:PropertyName("machineCode")
    var machineCode: String  = "",

    ) {
    @get:Exclude
    @set:Exclude
    @Transient
    lateinit var documentReference: DocumentReference

    companion object {
        fun fromSnapshot(snapshot: DocumentSnapshot): Machine {
            val machine = snapshot.toObject<Machine>()!!
            machine.documentReference = snapshot.reference
            return machine
        }
    }
}

