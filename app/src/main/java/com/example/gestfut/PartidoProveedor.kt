package com.example.gestfut

object PartidoProveedor {
    val listaPartidos = mutableListOf(
        Partido(
            jornada = 1,
            equipoLocal = EquipoProveedor.listaEquipos[0],
            equipoVisitante = EquipoProveedor.listaEquipos[1],
            golesLocal = 2,
            golesVisitante = 3
        ),
        Partido(
            jornada = 1,
            equipoLocal = EquipoProveedor.listaEquipos[2],
            equipoVisitante = EquipoProveedor.listaEquipos[3],
            golesLocal = 0,
            golesVisitante = 3
        ),
        Partido(
            jornada = 2,
            equipoLocal = EquipoProveedor.listaEquipos[0],
            equipoVisitante = EquipoProveedor.listaEquipos[2],
            golesLocal = 1,
            golesVisitante = 1
        ),
        Partido(
            jornada = 2,
            equipoLocal = EquipoProveedor.listaEquipos[1],
            equipoVisitante = EquipoProveedor.listaEquipos[3],
            golesLocal = 4,
            golesVisitante = 2
        )
    )
}