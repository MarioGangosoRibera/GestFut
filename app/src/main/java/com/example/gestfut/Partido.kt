package com.example.gestfut

data class Partido(
    val jornada: Int,
    val equipoLocal: Equipo,
    val equipoVisitante: Equipo,
    var golesLocal: Int? = null,
    var golesVisitante: Int? = null
)
