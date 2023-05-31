package com.optic.app_movil_tfc.domain.model

import com.google.gson.Gson

data class Task(
    val category : String = "",
    val end:String= "",
    val lastDate:String= "",
    val nameTarea:String= "",
    val selectedFrecunce:String= "",
    val start:String= "",
    val state:String= "",
    val datos : ArrayList<String> = ArrayList(),
    val repuestos : ArrayList<Repuesto> = ArrayList()

){
    fun toJson():String = Gson().toJson(Task(
        category,
        end,
        lastDate,
        nameTarea,
        selectedFrecunce,
        start,
        state,
        datos,
        repuestos,
    ))

    companion object{
        fun fromJson(data:String) : Task = Gson().fromJson(data,Task::class.java)
    }
}
