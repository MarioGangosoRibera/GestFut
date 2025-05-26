package com.example.gestfut.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.motion.widget.MotionScene.Transition.TransitionOnClick
import androidx.recyclerview.widget.RecyclerView
import com.example.gestfut.Equipo
import com.example.gestfut.R

class EquipoAdapter(
    private var lista: List<Equipo>,
    private val onClick: (Equipo) -> Unit
) : RecyclerView.Adapter<EquipoAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val imgEscudo: ImageView = view.findViewById(R.id.imgEscudo)
        val textNombre: TextView = view.findViewById(R.id.textNombre)
        val textEstadio: TextView = view.findViewById(R.id.textEstadio)
        val textPuntos: TextView = view.findViewById(R.id.textPuntos)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_equipo, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = lista.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val equipo = lista[position]
        holder.imgEscudo.setImageResource(equipo.escudo)
        holder.textNombre.text = equipo.nombre
        holder.textEstadio.text = equipo.estadio
        holder.textPuntos.text = "${equipo.puntos} pts"

        holder.itemView.setOnClickListener{onClick(equipo)}
    }

    fun actualizar(listaNueva: List<Equipo>){
        lista = listaNueva
        notifyDataSetChanged()
    }


}