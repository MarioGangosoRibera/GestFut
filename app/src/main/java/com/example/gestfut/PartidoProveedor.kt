package com.example.gestfut

object PartidoProveedor {
    val listaPartidos = mutableListOf(
        Partido(1, EquipoProveedor.listaEquipos[0], EquipoProveedor.listaEquipos[1]),
        Partido(1, EquipoProveedor.listaEquipos[2], EquipoProveedor.listaEquipos[3]),
        Partido(2, EquipoProveedor.listaEquipos[0], EquipoProveedor.listaEquipos[2]),
        Partido(2, EquipoProveedor.listaEquipos[1], EquipoProveedor.listaEquipos[3])
    )
}