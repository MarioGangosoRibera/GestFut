package com.example.gestfut

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gestfut.databinding.ActivityClasificacionBinding
import com.example.gestfut.databinding.ActivityDetalleEquipoBinding

class DetalleEquipoActivity : AppCompatActivity(){

    private lateinit var binding: ActivityDetalleEquipoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleEquipoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Obtener datos del intent
        val nombre = intent.getStringExtra("equipoNombre") ?: "Sin nombre"
        val estadio = intent.getStringExtra("equipoEstadio") ?: "Sin estadio"
        val escudo = intent.getIntExtra("equipoEscudo", R.drawable.ic_launcher_foreground)

        //Mostrar datos
        binding.textDetalleNombre.text = nombre
        binding.textDetalleEstadio.text = estadio
        binding.imgDetalleEscudo.setImageResource(escudo)
    }
}