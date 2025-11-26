package com.julian.poo.exercises

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.julian.poo.R

class CitaActivity : AppCompatActivity() {

    private val citas = listOf(
        Cita("La única forma de hacer un gran trabajo es amar lo que haces.",  "Steve Jobs"),
        Cita("La vida es lo que pasa mientras estás ocupado haciendo otros planes.",  "John Lennon"),
        Cita("El propósito de nuestras vidas es ser felices.",  "Dalai Lama"),
        Cita("No cuentes los días, haz que los días cuenten.",  "Muhammad Ali"),
        Cita("El único modo de salir de un laberinto es inventar tu propio camino.",  "John Green"),
        Cita("La mayor gloria no es nunca caer, sino levantarse siempre.",  "Nelson Mandela"),
        Cita("La creatividad es la inteligencia divirtiéndose.",  "Albert Einstein"),
        Cita("La vida es un 10% lo que te ocurre y un 90% cómo reaccionas a ello.",  "Charles R. Swindoll"),
        Cita("No juzgues cada día por la cosecha que recoges, sino por las semillas que plantas.",  "Robert Louis Stevenson"),
        Cita("El futuro pertenece a quienes creen en la belleza de sus sueños.",  "Eleanor Roosevelt"),
        Cita("Es duro fracasar, pero es peor no haber intentado nunca triunfar.",  "Theodore Roosevelt"),
        Cita("El éxito es la suma de pequeños esfuerzos repetidos día tras día.",  "Robert Collier"),
        Cita("Cree que puedes y ya estás a medio camino.",  "Theodore Roosevelt"),
        Cita("Para tener éxito, tu deseo de éxito debe ser mayor que tu miedo al fracaso.",  "Bill Cosby"),
        Cita("Un viaje de mil millas comienza con un solo paso.",  "Lao Tzu"),
        Cita("La lógica te llevará de A a B. La imaginación te llevará a todas partes.",  "Albert Einstein"),
        Cita("Sueña como si fueras a vivir para siempre, vive como si fueras a morir hoy.",  "James Dean"),
        Cita("No dejes que el ruido de las opiniones de otros apague tu propia voz interior.",  "Steve Jobs"),
        Cita("La mejor venganza es un éxito masivo.",  "Frank Sinatra"),
        Cita("El que no es lo suficientemente valiente para tomar riesgos no logrará nada en la vida.",  "Muhammad Ali")
    )

     lateinit var tvCita : TextView
     lateinit var tvAutor : TextView
     lateinit var btnNuevaCita : Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cita)

        tvCita = findViewById(R.id.tv_cita)
        tvAutor = findViewById(R.id.tv_autor)
        btnNuevaCita = findViewById(R.id.btn_nueva_cita)

        btnNuevaCita.setOnClickListener {
            val citaAleatoria = citas.random()
            tvCita.text ="\"${citaAleatoria.texto}\""
            tvAutor.text = citaAleatoria.autor
        }

    }


}