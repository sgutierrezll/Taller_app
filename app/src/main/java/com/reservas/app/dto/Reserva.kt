package com.reservas.app.dto

data class Reserva(
    val id: String,
    val createdAt: String,
    val updatedAt: String,
    val estado: Boolean,
    val mensaje: String,
    val fechaHora: String
)
