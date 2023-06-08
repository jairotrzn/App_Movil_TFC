package com.optic.app_movil_tfc.domain.model
import com.google.firebase.firestore.PropertyName
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.ktx.toObject
import com.google.gson.Gson

data class Repuesto(
    var id:String ="",
    var idRepuesto: String = "",
    var name: String = "",
    var price: String = "",
    var supplier: String = "",
){

    fun toJson():String = Gson().toJson(Repuesto(
        id,
        idRepuesto,
        name,
        price,
        supplier
    ))
    companion object {
        fun  fromJson(data: String): Repuesto = Gson().fromJson(data, Repuesto::class.java)
    }
}