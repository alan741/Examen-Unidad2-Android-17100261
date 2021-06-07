package com.example.a17100261examenu2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import java.time.LocalDate

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle? ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val edtTitulo: EditText = view.findViewById(R.id.edtTitulo)
        val edtAutor: EditText = view.findViewById(R.id.edtAutor)
        val edtAlbum: EditText = view.findViewById(R.id.edtAlbum)

        val btnGuardar:Button = view.findViewById(R.id.btnGuardar)
        btnGuardar.setOnClickListener {
            val titulo = edtTitulo.text.toString()
            val autor = edtAutor.text.toString()
            val album = edtAlbum.text.toString()

            val artista = artista(titulo,autor,album)
            Datos.artistas.add(artista)

            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)

        }

    }
}