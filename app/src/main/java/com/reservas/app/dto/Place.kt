package com.reservas.app.dto

data class Place(
    val id: String,
    val name: String,
    val description: String,
    val latitude: Number,
    val longitude: Number
)