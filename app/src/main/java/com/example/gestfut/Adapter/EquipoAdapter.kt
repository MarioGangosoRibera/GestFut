package com.example.gestfut.Adapter

// Importaciones necesarias
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gestfut.Equipo
import com.example.gestfut.R

// Adaptador para mostrar una lista de objetos Equipo en un RecyclerView
class EquipoAdapter(
    private var lista: List<Equipo>, // Lista de equipos que se va a mostrar
    private val onClick: (Equipo) -> Unit // Función lambda para manejar el clic sobre un equipo
) : RecyclerView.Adapter<EquipoAdapter.ViewHolder>() {

    // ViewHolder interno que contiene las referencias a las vistas del ítem
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgEscudo: ImageView = view.findViewById(R.id.imgEscudo) // Imagen del escudo del equipo
        val textNombre: TextView = view.findViewById(R.id.textNombre) // Nombre del equipo
        val textEstadio: TextView = view.findViewById(R.id.textEstadio) // Nombre del estadio
        val textPuntos: TextView = view.findViewById(R.id.textPuntos) // Puntos actuales del equipo
    }

    // Crea las vistas (ítems) inflando el layout XML correspondiente
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_equipo, parent, false) // Inflamos item_equipo.xml
        return ViewHolder(view)
    }

    // Devuelve el número total de elementos en la lista
    override fun getItemCount(): Int = lista.size

    // Asocia los datos del equipo con la vista del ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val equipo = lista[position]

        // Establece el escudo (imagen), el nombre, estadio y puntos del equipo
        holder.imgEscudo.setImageResource(equipo.escudo)
        holder.textNombre.text = equipo.nombre
        holder.textEstadio.text = equipo.estadio
        holder.textPuntos.text = "${equipo.puntos} pts"

        // Al hacer clic en el ítem, se ejecuta la función onClick con el equipo correspondiente
        holder.itemView.setOnClickListener { onClick(equipo) }
    }

    // Método para actualizar la lista de equipos y notificar cambios al RecyclerView
    fun actualizar(listaNueva: List<Equipo>) {
        lista = listaNueva
        notifyDataSetChanged()
    }
}
