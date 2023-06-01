package com.optic.app_movil_tfc.domain.model
import com.google.firebase.firestore.PropertyName
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.ktx.toObject

data class Repuesto(
    @get:PropertyName("idRepuesto")
    @set:PropertyName("idRepuesto")
    var idRepuesto: String = "",

    @get:PropertyName("name")
    @set:PropertyName("name")
    var name: String = "",

    @get:PropertyName("price")
    @set:PropertyName("price")
    var price: String = "",

    @get:PropertyName("supplier")
    @set:PropertyName("supplier")
    var supplier: String = "",
){
    @get:Exclude
    @set:Exclude
    @Transient
    lateinit var documentReference: DocumentReference

    companion object {
        fun fromSnapshot(snapshot: DocumentSnapshot): Repuesto {
            val repuesto = snapshot.toObject<Repuesto>()!!
            repuesto.documentReference = snapshot.reference
            return repuesto
        }
    }
}