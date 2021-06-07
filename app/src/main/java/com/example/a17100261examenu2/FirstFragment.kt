package com.example.a17100261examenu2

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import java.time.LocalDate
import kotlin.random.Random

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    lateinit var recycler: RecyclerView
    lateinit var adaptador: ArtistasAdapter

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,  savedInstanceState: Bundle? ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        setHasOptionsMenu(true)

        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler = view.findViewById(R.id.recyclerView)
        recycler.layoutManager = LinearLayoutManager(requireActivity())

        //Medidas Adapter pide una funcion como parametro
        adaptador = ArtistasAdapter{
            m ->MostrarArtista(m)
        }

        recycler.adapter = adaptador

        val fab:FloatingActionButton = view.findViewById(R.id.fabFirstFragment)
        fab.setOnClickListener{
            //agregamos este objeto vacio al arreglo al dar clic al fab
            val titulo = "Desconosido"
            val autor = "Desconosido"
            val album = "Desconosido"

            Datos.artistas.add( artista(titulo,autor, album) )
            adaptador.notifyDataSetChanged()
        }
    }

    private fun MostrarArtista(m: artista) {
        Snackbar.make(
            recycler,
            "Cancion (Titulo: ${m.titulo}, artistas: ${m.autor}, album: ${m.album}",
            Snackbar.LENGTH_LONG
        ).show()
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.mnu_add -> {
                //navega al segundo fragmento
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
                true
            }
            R.id.mnu_intent_implicita ->{
                val sendIntent = Intent().apply {
                    action = Intent.ACTION_SEND //envia una accion
                    putExtra(Intent.EXTRA_TEXT, "Hey!! ya probaste la nueva app de musica?")
                    type = "text/plain"
                }
                startActivity(sendIntent)
                true
            }
          else -> super.onOptionsItemSelected(item)
        }
    }


}
// findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)