package com.julian.poo.chapter1

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.julian.poo.R

class Usuario(val id : Int, var nombre : String)
class Example1Activity : AppCompatActivity() {

    lateinit var usuario : Usuario
    lateinit var tvNombreUsuario : TextView
    lateinit var btnCambiarNombre : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_example1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.layout_example_1)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Inicialización de vistas
        tvNombreUsuario = findViewById(R.id.tv_nombre_usuario)
        btnCambiarNombre = findViewById(R.id.btn_cambiar_nombre)

        var numero = "7"
        var nu1 = numero.toInt()

        //Creación del objeto POO
        usuario = Usuario(101, "Manuel")
        Log.d("Example1", "El nombre es ${usuario.nombre}")
        usuario.nombre = "Patito"
        Log.d("Example1", "El identificador es ${usuario.id}")
        Log.d("Example1", "El nombre es ${usuario.nombre}")
        tvNombreUsuario.text = "ID: ${usuario.id} | Nombre: ${usuario.nombre}"

        btnCambiarNombre.setOnClickListener {
            //Modificar la propiedad nombre
            usuario.nombre = "Joselito"
            tvNombreUsuario.text = "ID: ${usuario.id} | Nombre: ${usuario.nombre}"
        }

    }
}