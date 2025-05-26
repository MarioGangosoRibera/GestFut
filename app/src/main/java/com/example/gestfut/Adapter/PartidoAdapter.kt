package com.example.gestfut.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gestfut.Partido
import com.example.gestfut.R

class PartidoAdapter (
    private var lista: List<Partido>,
    private val onItemClick: (Partido) -> Unit
) : RecyclerView.Adapter<PartidoAdapter.ViewHolder>(){

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val textJornada: TextView = view.findViewById(R.id.textJornada)
        val textEquipos: TextView = view.findViewById(R.id.textEquipos)
        val textResultado: TextView = view.findViewById(R.id.textResultado)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_partido, parent, false)
        return ViewHolder(vista)
    }

    override fun getItemCount(): Int = lista.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val partido = lista[position]
        holder.textJornada.text = "Jornada ${partido.jornada}"
        holder.textEquipos.text = "${partido.equipoLocal.nombre} vs ${partido.equipoVisitante.nombre}"

        val golesLocal = partido.golesLocal
        val golesVisitante = partido.golesVisitante

        if (golesLocal != null && golesVisitante != null){
            holder.textResultado.text = "Resultado: $golesLocal - $golesVisitante"
        } else {
            holder.textResultado.text = "Resultado: pendiente"
        }

        holder.itemView.setOnClickListener{
            onItemClick(partido)
        }
    }

    fun actualizarLista(nuevaLista: List<Partido>){
        lista=nuevaLista
        notifyDataSetChanged()
    }

}