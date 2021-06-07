package com.example.a17100261examenu2

import java.time.LocalDate

object Datos {
    val artistas : ArrayList<artista> = arrayListOf()
}

//Clase de Medidas
data class artista(val titulo: String, val autor: String, val album: String){

        val imagen =
        if(autor == "Lady Gaga") R.drawable.logingaga
        else if(autor == "Katy Perry") R.drawable.logingaga
        else if(autor == "Lorde") R.drawable.logingaga
        else R.drawable.logingaga
}