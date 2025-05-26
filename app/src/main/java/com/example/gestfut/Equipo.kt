package com.example.gestfut

data class Equipo(
    val nombre: String,
    val estadio: String,
    val escudo: Int, // ID del recurso drawable
    var puntos: Int = 0,
    var golesFavor: Int = 0,
    var golesContra: Int = 0
)