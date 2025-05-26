package com.example.gestfut

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gestfut.Adapter.PartidoAdapter
import com.example.gestfut.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PartidoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Calcula puntos en base a los resultados iniciales
        recalcularPuntos()

        // Configurar el RecyclerView con los partidos
        adapter = PartidoAdapter(PartidoProveedor.listaPartidos) { partido ->
            // Aquí puedes abrir un dialog si lo deseas, o dejarlo como está
        }

        binding.recyclerPartidos.layoutManager = LinearLayoutManager(this)
        binding.recyclerPartidos.adapter = adapter

        // Botón para ir a ClasificaciónActivity
        binding.btnVerClasificacion.setOnClickListener {
            startActivity(Intent(this, ClasificacionActivity::class.java))
        }
    }

    // Calcula los puntos de los equipos en base a los partidos
    private fun recalcularPuntos() {
        val equipos = EquipoProveedor.listaEquipos

        // Reiniciar estadísticas
        equipos.forEach {
            it.puntos = 0
            it.golesFavor = 0
            it.golesContra = 0
        }

        for (partido in PartidoProveedor.listaPartidos) {
            val gl = partido.golesLocal
            val gv = partido.golesVisitante

            if (gl != null && gv != null) {
                val local = partido.equipoLocal
                val visitante = partido.equipoVisitante

                local.golesFavor += gl
                local.golesContra += gv
                visitante.golesFavor += gv
                visitante.golesContra += gl

                when {
                    gl > gv -> local.puntos += 3
                    gl < gv -> visitante.puntos += 3
                    else -> {
                        local.puntos += 1
                        visitante.puntos += 1
                    }
                }
            }
        }
    }
}
