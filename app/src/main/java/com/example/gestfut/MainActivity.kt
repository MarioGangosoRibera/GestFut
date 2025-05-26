package com.example.gestfut

// Importaciones necesarias
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gestfut.Adapter.PartidoAdapter
import com.example.gestfut.databinding.ActivityMainBinding

// Actividad principal de la app
class MainActivity : AppCompatActivity() {

    // ViewBinding para acceder a las vistas del layout
    private lateinit var binding: ActivityMainBinding

    // Adaptador que mostrará los partidos en el RecyclerView
    private lateinit var adapter: PartidoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflar layout usando ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 🧮 Recalcular los puntos de los equipos antes de mostrar la clasificación
        recalcularPuntos()

        // 🔁 Inicializar el RecyclerView para mostrar la lista de partidos
        adapter = PartidoAdapter(PartidoProveedor.listaPartidos) { partido ->
            // Acción al hacer clic en un partido (actualmente vacía, se puede ampliar)
        }

        // Configurar RecyclerView con layout vertical y asignar el adaptador
        binding.recyclerPartidos.layoutManager = LinearLayoutManager(this)
        binding.recyclerPartidos.adapter = adapter

        // ➡️ Configurar botón que lleva a la pantalla de clasificación
        binding.btnVerClasificacion.setOnClickListener {
            startActivity(Intent(this, ClasificacionActivity::class.java))
        }
    }

    // Función que recalcula los puntos de los equipos según los resultados de los partidos
    private fun recalcularPuntos() {
        val equipos = EquipoProveedor.listaEquipos

        // Reiniciar estadísticas (evita que se acumulen al recargar)
        equipos.forEach {
            it.puntos = 0
            it.golesFavor = 0
            it.golesContra = 0
        }

        // Recorrer todos los partidos jugados
        for (partido in PartidoProveedor.listaPartidos) {
            val gl = partido.golesLocal
            val gv = partido.golesVisitante

            if (gl != null && gv != null) { // Solo se consideran partidos con resultado

                val local = partido.equipoLocal
                val visitante = partido.equipoVisitante

                // Sumar goles a favor y en contra
                local.golesFavor += gl
                local.golesContra += gv
                visitante.golesFavor += gv
                visitante.golesContra += gl

                // Asignar puntos según el resultado
                when {
                    gl > gv -> local.puntos += 3 // Gana local
                    gl < gv -> visitante.puntos += 3 // Gana visitante
                    else -> { // Empate
                        local.puntos += 1
                        visitante.puntos += 1
                    }
                }
            }
        }
    }
}
