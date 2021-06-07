package com.example.a17100261examenu2

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivityLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_login)

        var txtUsuario: EditText = findViewById(R.id.edtUsuario)
        var txtContrasena: EditText = findViewById(R.id.edtContrasena)

        var btnGuardar: Button = findViewById(R.id.btnEntrar)
        btnGuardar.setOnClickListener {

            //startActivity(intent)
            if (txtUsuario.text.toString() == "alan" && txtContrasena.text.toString() == "1234")
            {
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                Toast.makeText(this,"Bienvenido",Toast.LENGTH_LONG).show()
            }else
            {
                Log.e("Alan","Entre aqui!!")
                val builderDialog = AlertDialog.Builder(this)
                builderDialog.setTitle("Error!!!")
                builderDialog.setMessage("Contraseña incorrecta")
                builderDialog.setNeutralButton("Ok", { dialogInterface: DialogInterface, i: Int -> })
                builderDialog.show()
            }

        }
    }
}