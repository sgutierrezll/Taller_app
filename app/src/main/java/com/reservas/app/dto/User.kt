package com.reservas.app.dto
import com.fasterxml.jackson.annotation.JsonProperty

//data class User (
//    @JsonProperty("id") val id: String,
//    @JsonProperty("first_name") val first_name: String,
//    @JsonProperty("last_name") val last_name: String,
//    @JsonProperty("cell_phone") val cell_phone: String,
//    @JsonProperty("email") val email: String,
//    @JsonProperty("username") val username: String,
//    @JsonProperty("password") val password: String,
//    @JsonProperty("role") val role: String,
//    @JsonProperty("is_active") val is_active: Int
//)

data class User(
    val id: String,
    val firstName: String,
    val lastName: String,
    val cellPhone: String,
    val email: String,
    val username: String,
    val password: String,
    val role: String,
    val isActive: Boolean
)
