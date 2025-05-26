package com.example.gestfut

// Importaciones necesarias
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gestfut.databinding.ActivityDetalleEquipoBinding

// Actividad para mostrar el detalle de un equipo seleccionado
class DetalleEquipoActivity : AppCompatActivity() {

    // ViewBinding para acceder a las vistas del layout de forma segura
    private lateinit var binding: ActivityDetalleEquipoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflar la vista usando ViewBinding
        binding = ActivityDetalleEquipoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtener los datos enviados desde la ClasificacionActivity mediante el Intent
        val nombre = intent.getStringExtra("equipoNombre") ?: "Sin nombre" // Si no hay dato, pone "Sin nombre"
        val estadio = intent.getStringExtra("equipoEstadio") ?: "Sin estadio"
        val escudo = intent.getIntExtra("equipoEscudo", R.drawable.ic_launcher_foreground)
        // Si no se encuentra el escudo, se usa un ícono por defecto

        // Mostrar los datos obtenidos en las vistas correspondientes
        binding.textDetalleNombre.text = nombre
        binding.textDetalleEstadio.text = estadio
        binding.imgDetalleEscudo.setImageResource(escudo)
    }
}
