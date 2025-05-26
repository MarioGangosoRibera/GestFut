package com.example.gestfut

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gestfut.Adapter.EquipoAdapter
import com.example.gestfut.databinding.ActivityClasificacionBinding

class ClasificacionActivity : AppCompatActivity(){

    private lateinit var binding: ActivityClasificacionBinding
    private lateinit var adapter: EquipoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClasificacionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = EquipoAdapter(EquipoProveedor.listaEquipos.sortedByDescending { it.puntos }){ equipo ->
          val intent = Intent(this, DetalleEquipoActivity::class.java)
          intent.putExtra("equipoNombre", equipo.nombre)
            intent.putExtra("equipoEstadio", equipo.estadio)
            intent.putExtra("equipoEscudo", equipo.escudo)
            startActivity(intent)

        }
        binding.recyclerClasificacion.layoutManager = LinearLayoutManager(this)
        binding.recyclerClasificacion.adapter = adapter
    }
}