package com.optic.app_movil_tfc.domain.model

import com.google.gson.Gson
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

data class Preventiv(
    var id:String ="",
    val accessCode: String = "",
    val color: String = "",
    val end: String = "",
    var machineCode: Machine? = null,
    val namePersonInCharge: String = "",
    val password: String = "",
    val start: String = "",
    val tareas: Task ?= null,

    ) {
    fun toJson(): String = Gson().toJson(
        Preventiv(
            id,
            accessCode,
            color,
            end,
            Machine(
                current = machineCode?.current ?: "",
                department = machineCode?.current ?: "",
                feedMotorPower = machineCode?.current ?: "",
                id = machineCode?.current ?: "",
                if (!machineCode?.image.isNullOrBlank())
                    URLEncoder.encode(machineCode?.image, StandardCharsets.UTF_8.toString())
                else "",
                location = machineCode?.current ?: "",
                machineCode = machineCode?.machineCode ?: 0,
                mainMotorPower = machineCode?.mainMotorPower ?: 0,
                maximumLongitudinalFeed = machineCode?.maximumLongitudinalFeed ?: 0,
                maximumSpeed = machineCode?.maximumSpeed ?: 0,
                maximumTransversalFeed = machineCode?.maximumTransversalFeed ?: 0,
                maximumVerticalFeed = machineCode?.maximumVerticalFeed ?: 0,
                minimumLongitudinalFeed = machineCode?.minimumLongitudinalFeed ?: 0,
                minimumSpeed = machineCode?.minimumSpeed ?: 0,
                minimumTransversalFeed = machineCode?.minimumTransversalFeed ?: 0,
                minimumVerticalFeed = machineCode?.minimumVerticalFeed ?: 0,
                numberOfLongitudinalFeeds = machineCode?.numberOfLongitudinalFeeds ?: 0,
                numberOfSpeeds = machineCode?.numberOfSpeeds ?: 0,
                numberOfTransversalFeeds = machineCode?.numberOfTransversalFeeds ?: 0,
                numberOfVerticalFeeds = machineCode?.numberOfVerticalFeeds ?: 0,
                pumpMotorPower = machineCode?.pumpMotorPower ?: 0,
                type = machineCode?.type ?: "",
            ),
            namePersonInCharge,
            password,
            start,
            Task(
                category = tareas?.category?:"",
                end = tareas?.end?:"",
                lastDate = tareas?.lastDate?:"",
                nameTarea = tareas?.nameTarea?:"",
                selectedFrecunce = tareas?.selectedFrecunce?:"",
                start = tareas?.start?:"",
                state = tareas?.state?:"",
                datos = tareas?.datos?:ArrayList(),
                repuestos = tareas?.repuestos?: ArrayList(),
            )

        )
    )
    companion object {
        fun fromJson(data: String): Preventiv = Gson().fromJson(data, Preventiv::class.java)
    }
}
