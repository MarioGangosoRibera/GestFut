package com.example.gestfut

// Importaciones necesarias para la actividad y componentes de UI
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gestfut.Adapter.EquipoAdapter
import com.example.gestfut.databinding.ActivityClasificacionBinding

// Clase de la actividad que muestra la clasificación de equipos
class ClasificacionActivity : AppCompatActivity() {

    // ViewBinding para acceder a los elementos de la interfaz XML
    private lateinit var binding: ActivityClasificacionBinding

    // Adaptador para mostrar los equipos en el RecyclerView
    private lateinit var adapter: EquipoAdapter

    // Método que se ejecuta al crear la actividad
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflamos el layout usando ViewBinding
        binding = ActivityClasificacionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Creamos el adaptador con la lista de equipos ordenados por puntos de forma descendente
        adapter = EquipoAdapter(EquipoProveedor.listaEquipos.sortedByDescending { it.puntos }) { equipo ->
            // Al hacer clic en un equipo, abrimos la actividad de detalle y pasamos los datos
            val intent = Intent(this, DetalleEquipoActivity::class.java)
            intent.putExtra("equipoNombre", equipo.nombre)
            intent.putExtra("equipoEstadio", equipo.estadio)
            intent.putExtra("equipoEscudo", equipo.escudo)
            startActivity(intent)
        }

        // Configuramos el RecyclerView con un LinearLayoutManager y el adaptador
        binding.recyclerClasificacion.layoutManager = LinearLayoutManager(this)
        binding.recyclerClasificacion.adapter = adapter
    }
}
