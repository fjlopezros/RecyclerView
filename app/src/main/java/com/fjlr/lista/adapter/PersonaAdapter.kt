package com.fjlr.lista.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fjlr.lista.R
import com.fjlr.lista.modelo.Persona
import com.squareup.picasso.Picasso

class PersonaAdapter (private val listaPersonas: List<Persona>,
    private val fn: (Persona) -> Unit):
    RecyclerView.Adapter<PersonaAdapter.PersonaViewHolder>(){

    inner class PersonaViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val ivProducto: ImageView? = view.findViewById<ImageView>(R.id.ivProducto)
        val tvDni: TextView? = view.findViewById<TextView>(R.id.tvDni)
        val tvNombre: TextView? = view.findViewById<TextView>(R.id.tvNombre)
        val tvApellidos: TextView? = view.findViewById<TextView>(R.id.tvApellidos)

        fun bind(persona: Persona){
            tvDni?.text = persona.dni
            tvNombre?.text = persona.nombre
            tvApellidos?.text = persona.apellidos

            Picasso.get().load(persona.foto).into(ivProducto)

            itemView.setOnClickListener {
                fn(persona)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonaViewHolder {
        val layoutInflater = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.persona_item,
                parent,
                false)
        return PersonaViewHolder(layoutInflater)
    }

    override fun getItemCount(): Int = listaPersonas.size

    override fun onBindViewHolder(holder: PersonaViewHolder, position: Int) {
        holder.bind(listaPersonas[position])
    }

}