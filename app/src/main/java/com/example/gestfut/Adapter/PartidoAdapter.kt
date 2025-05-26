package com.example.gestfut.Adapter

// Importaciones necesarias para trabajar con vistas, RecyclerView, y el modelo Partido
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gestfut.Partido
import com.example.gestfut.R

// Clase adaptador personalizada para mostrar una lista de objetos Partido
class PartidoAdapter (
    private var lista: List<Partido>, // Lista de partidos que se mostrará en el RecyclerView
    private val onItemClick: (Partido) -> Unit // Función lambda que se ejecutará al hacer clic en un ítem
) : RecyclerView.Adapter<PartidoAdapter.ViewHolder>() {

    // Clase interna ViewHolder: contiene las referencias a las vistas que se van a rellenar
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textJornada: TextView = view.findViewById(R.id.textJornada)
        val textEquipos: TextView = view.findViewById(R.id.textEquipos)
        val textResultado: TextView = view.findViewById(R.id.textResultado)
    }

    // Método que crea nuevas vistas (invocado por el layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflamos el diseño XML de un ítem (item_partido)
        val vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_partido, parent, false)
        return ViewHolder(vista)
    }

    // Devuelve la cantidad total de elementos que hay en la lista
    override fun getItemCount(): Int = lista.size

    // Este método enlaza los datos con cada vista del ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val partido = lista[position]

        // Mostramos la jornada del partido
        holder.textJornada.text = "Jornada ${partido.jornada}"

        // Mostramos los nombres de los equipos
        holder.textEquipos.text = "${partido.equipoLocal.nombre} vs ${partido.equipoVisitante.nombre}"

        // Mostramos el resultado si está disponible, si no, mostramos "pendiente"
        val golesLocal = partido.golesLocal
        val golesVisitante = partido.golesVisitante

        if (golesLocal != null && golesVisitante != null){
            holder.textResultado.text = "Resultado: $golesLocal - $golesVisitante"
        } else {
            holder.textResultado.text = "Resultado: pendiente"
        }

        // Asignamos el listener de clic para el ítem completo
        holder.itemView.setOnClickListener{
            onItemClick(partido)
        }
    }

    // Método para actualizar la lista y notificar al RecyclerView que debe refrescarse
    fun actualizarLista(nuevaLista: List<Partido>) {
        lista = nuevaLista
        notifyDataSetChanged()
    }
}
