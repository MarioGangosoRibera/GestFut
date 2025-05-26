package com.example.gestfut

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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

        adapter = PartidoAdapter(PartidoProveedor.listaPartidos) { partido ->
            Toast.makeText(this, "Clic en: ${partido.equipoLocal.nombre} vs ${partido.equipoVisitante.nombre}", Toast.LENGTH_SHORT).show()
        }

        binding.recyclerPartidos.layoutManager = LinearLayoutManager(this)
        binding.recyclerPartidos.adapter = adapter

        binding.btnVerClasificacion.setOnClickListener {
            val intent = Intent(this, ClasificacionActivity::class.java)
            startActivity(intent)
        }
    }

}