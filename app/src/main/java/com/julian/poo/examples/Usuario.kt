package com.julian.poo.examples

import android.util.Log

//Bloque init

class Usuario (var nombre : String, var apodo : String = "Fulanita"){
    var nombreMayuscula : String

    init{
        //Validación de datos
        require(nombre.isNotBlank()) { "El nombre no puede estar vacio"}
        //Iniciacilizacion de propiedades calculadas
        nombreMayuscula = nombre.uppercase()
        Log.i("Usuario", "${nombreMayuscula} inicializado " )
    }

    override
    fun toString() : String{
        return "$nombre $apodo $nombreMayuscula"
    }


}