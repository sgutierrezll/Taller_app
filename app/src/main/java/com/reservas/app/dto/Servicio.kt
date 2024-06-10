package com.reservas.app.dto

data class Servicio (
    val id: String,
    val createdAt: String,
    val updatedAt: String,
    val nombre: String,
    val descricion: String,
    val imagen: String,
    val estaDisponible: String,
)
