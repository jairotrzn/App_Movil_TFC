package com.optic.app_movil_tfc.domain.model
import com.google.gson.Gson

data class Repuesto(
    val id:String,
    val idRepuesto :String,
    val name: String,
    val price: Number,
    val supplier:String,
){
    fun toJson():String = Gson().toJson(Repuesto(
        id,
        idRepuesto,
        name,
        price,
        supplier
    ))

    companion object{
        fun fromJson(data :String):Repuesto = Gson().fromJson(data,Repuesto::class.java)
    }
}
