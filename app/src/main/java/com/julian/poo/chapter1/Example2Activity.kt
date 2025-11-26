package com.julian.poo.chapter1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.julian.poo.R

class Credenciales(val usuario: String, val clave: String) {
    //Queremos que se ejecute cualquier cosa después de crear el objeto. Se utiliza init
    // con el constructor primario{
    init {
        //El bloque init valida las propiedades de constructor primario
        require(usuario.length >= 4) { "El usuario debe tener al menos 4 caracteres" }
        require(clave.length >= 6) { "La clave debe tener al menos 6 caracteres" }
    }
    //Constructor secundario para la simular la recepción de los datos de la vista.

    constructor(datosVista: Map<String, String>) : this(
        usuario = datosVista["usuario"] ?: "",
        clave = datosVista["clave"] ?: ""
    )

    constructor(par: Pair<String, String>) : this(
        usuario = par.first,
        clave = par.second
    )
}

lateinit var etUsuario: EditText
lateinit var etClave: EditText
lateinit var btnLogin: Button
lateinit var tvMensaje: TextView

class Example2Activity : AppCompatActivity() {


    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_example2)

        Credenciales("Patito", "123456")
        Credenciales(mapOf("usuario" to "Manolo", "clave" to "123456"))
        Credenciales(Pair("Antonio", "00000000"))

        etUsuario = findViewById(R.id.et_usuario)
        etClave = findViewById(R.id.et_clave)
        btnLogin = findViewById(R.id.btn_login)
        tvMensaje = findViewById(R.id.tv_mensaje)

        btnLogin.setOnClickListener {
            val datosVista = mapOf(
                "usuario" to etUsuario.text.toString(),
                "clave" to etClave.text.toString()
            )
            //Log.d("Example 2", datosVista.toString())
            try {
                val credencial = Credenciales(datosVista)
                tvMensaje.text = "Credenciales válidas! " +
                        "Usuario : ${credencial.usuario}"
                tvMensaje.setTextColor(
                    ContextCompat.getColor(
                        this,
                        android.R.color.holo_green_dark
                    )
                )
                //  tvMensaje.setTextColor(17170453)
            } catch (e: IllegalArgumentException) {
                //Capturamos la excepción y la pintamos
                tvMensaje.text = "Error de validación: ${e.message}"
                tvMensaje.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_dark))
            }

        }


    }
}