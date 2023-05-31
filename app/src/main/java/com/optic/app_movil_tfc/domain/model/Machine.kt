package com.optic.app_movil_tfc.domain.model

import com.google.gson.Gson
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

data class Machine(

    val current: String = "",
    val department: String = "",
    val feedMotorPower: String = "",
    val id: String = "",
    val image: String = "",
    val location: String = "",
    val machineCode: Number = 0,
    val mainMotorPower: Number = 0,
    val maximumLongitudinalFeed: Number = 0,
    val maximumSpeed: Number = 0,
    val maximumTransversalFeed: Number = 0,
    val maximumVerticalFeed: Number = 0,
    val minimumLongitudinalFeed: Number = 0,
    val minimumSpeed: Number = 0,
    val minimumTransversalFeed: Number = 0,
    val minimumVerticalFeed: Number = 0,
    val numberOfLongitudinalFeeds: Number = 0,
    val numberOfSpeeds: Number = 0,
    val numberOfTransversalFeeds: Number = 0,
    val numberOfVerticalFeeds: Number = 0,
    val pumpMotorPower: Number = 0,
    val type: String = "",

    ) {
    fun toJson(): String = Gson().toJson(
        Machine(
            current,
            department,
            feedMotorPower,
            id,
            if (image != "") URLEncoder.encode(image, StandardCharsets.UTF_8.toString()) else "",
            location,
            machineCode,
            mainMotorPower,
            maximumLongitudinalFeed,
            maximumSpeed,
            maximumTransversalFeed,
            maximumVerticalFeed,
            minimumLongitudinalFeed,
            minimumSpeed,
            minimumTransversalFeed,
            minimumVerticalFeed,
            numberOfLongitudinalFeeds,
            numberOfSpeeds,
            numberOfTransversalFeeds,
            numberOfVerticalFeeds,
            pumpMotorPower,
            type,
        )
    )
    companion object {
        fun fromJson(data: String): Machine = Gson().fromJson(data, Machine::class.java)
    }
}
