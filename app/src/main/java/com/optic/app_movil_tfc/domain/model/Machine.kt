package com.optic.app_movil_tfc.domain.model

import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.PropertyName
import com.google.firebase.firestore.ktx.toObject
import com.google.gson.Gson
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

data class Machine(
    var id: String = "",
    var current: Int = 0,
    var department: String = "",
    var feedMotorPower: Int = 0,
    var location: String = "",
    var image: String = "",
    var machineCode: String = "",
    var mainMotorPower: Int = 0,
    var maximumLongitudinalFeed: Int = 0,
    var maximumSpeed: Int = 0,
    var minimumLongitudinalFeed: Int = 0,
    var minimumSpeed: Int = 0,
    var maximumTransversalFeed: Int = 0,
    var minimumTransversalFeed: Int = 0,
    var numberOfLongitudinalFeeds: Int = 0,
    var numberOfSpeeds: Int = 0,
    var numberOfTransversalFeeds: Int = 0,
    var numberOfVerticalFeeds: Int = 0,
    var pumpMotorPower: Int = 0,
    var type: String = "",    var minimumVerticalFeed: Int = 0,
    var maximumVerticalFeed: Int = 0,



    ) {

    fun toJson(): String = Gson().toJson(
        Machine(
            id,
            current,
            department,
            feedMotorPower,
            location,
            if (image != "") URLEncoder.encode(image, StandardCharsets.UTF_8.toString()) else "",
            machineCode,
            mainMotorPower,
            maximumLongitudinalFeed,
            maximumSpeed,
            minimumLongitudinalFeed,
            minimumSpeed,
            maximumTransversalFeed,
            minimumTransversalFeed,
            numberOfLongitudinalFeeds,
            numberOfSpeeds,
            numberOfTransversalFeeds,
            numberOfVerticalFeeds,
            pumpMotorPower,
            type,
            minimumVerticalFeed,
            maximumVerticalFeed


        )
    )

    companion object {
        fun fromJson(data: String): Machine = Gson().fromJson(data, Machine::class.java)

    }
}
