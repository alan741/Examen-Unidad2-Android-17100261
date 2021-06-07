package com.example.a17100261examenu2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ArtistasAdapter(private val listener: (artista) -> Unit) : RecyclerView.Adapter<ArtistasAdapter.ViewHolder>() {

    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        //aqui dentro creamos los 4 textview y la imagen que tenemos en el xml,
        // debemos de crear las variables de la VISTA
        //son los elementos dentro de ssong_item

        val titulo: TextView = view.findViewById(R.id.txtTitulo)
        val autor: TextView = view.findViewById(R.id.txtArtista)
        val album : TextView = view.findViewById(R.id.txtAlbum)
        val imagen:ImageView = view.findViewById(R.id.imgImagen)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.song_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //ponemos elementos a cada widget de la lista
        //internamente este emtodo recorre el arreglo y lleva el conteo con la variable position asi que asignamos
        //por decir el peso del holder en la posicion 0 y asi con todos los elementos del arreglo
        holder.titulo.text = "Titulo: ${Datos.artistas.get(position).titulo}"
        holder.autor.text = "Titulo: ${Datos.artistas.get(position).autor}"
        holder.album.text = "Titulo: ${Datos.artistas.get(position).album}"
        holder.imagen.setImageResource(Datos.artistas.get(position).imagen)

        //cuando den clic al VIEW
        holder.itemView.setOnClickListener {
            listener(Datos.artistas.get(position))
        }
    }
    override fun getItemCount(): Int {
        //regresa el tamaño del arreglo de objetos,
        // o los elementos que son en total
        return Datos.artistas.size
    }
}