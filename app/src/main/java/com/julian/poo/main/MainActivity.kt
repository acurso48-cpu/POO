package com.julian.poo.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.julian.poo.R
import com.julian.poo.chapter1.Example1Activity
import com.julian.poo.chapter1.Example2Activity
import com.julian.poo.examples.Coche
import com.julian.poo.examples.ConfiguracionApp
import com.julian.poo.examples.Persona
import com.julian.poo.examples.Producto
import com.julian.poo.examples.Usuario
import com.julian.poo.exercises.CitaActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonGoToEx1 = findViewById<Button>(R.id.btn_go_to_ex1)
        buttonGoToEx1.setOnClickListener {
            Log.d("MainActivity", "Button clicked")
            val intent = Intent(this, Example1Activity::class.java)
            startActivity(intent)
        }

        val buttonGoToEx2 = findViewById<Button>(R.id.btn_go_to_ex2)
        buttonGoToEx2.setOnClickListener {
            Log.d("MainActivity", "Button clicked")
            val intent = Intent(this, CitaActivity::class.java)
            startActivity(intent)
        }

        val miCoche = Coche("Volvo")
        val miCoche2 = Coche("BMW", 50)
        val miCoche3 = Coche( velocidad = 85, marca = "Seat")
        miCoche.acelerar(100)
        miCoche2.acelerar(10)
        Log.i("Coche", "Marca: ${miCoche.marca}, Velocidad: ${miCoche.velocidad} ")
        Log.i("Coche", "Marca: ${miCoche2.marca}, Velocidad: ${miCoche2.velocidad} ")
        Log.i("Coche", "Marca: ${miCoche3.marca}, Velocidad: ${miCoche3.velocidad} ")
       // Log.e("Coche", "Error del sistema global")

        val persona1 = Persona("Manolo", 25)
        val persona2 = Persona("José")
        Log.i("Persona", "${persona1.nombre}")

        //Ejemplo init
        try {
            val user1 = Usuario("Alicia")
            Log.i("Usuario", user1.toString())
            val user2 = Usuario("")

        } catch (e : IllegalArgumentException){
            Log.e("Usuario", e.message.toString())
        }

        //Ejemplo data class

        val producto1 = Producto( 1, "Móvil", 520.0)
        //Copia modificada
        val producto2 = producto1.copy(id =3 , nombre = "Celular")
        Log.i("Producto", producto1.toString())
        Log.i("Producto", producto2.toString())

        val (id1, nombre1, precio1) = producto1
        val ( _ , nombre2, precio2) = producto2
        val nombre14 = producto2.component2() // "Celular"
        val nombre15 = producto2.nombre // "Celular"

        //Object

        ConfiguracionApp.temaOscuro = false
        ConfiguracionApp.inicializar() //Invocando un método del objeto




    }
}