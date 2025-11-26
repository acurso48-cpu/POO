package com.julian.poo.examples

import android.util.Log

//Ejemplo de constructor primario y secundario

class Persona (val nombre: String , val edad : Int){
    //Constructor secundario
    constructor(nombre : String) : this (nombre, 0) {
        Log.i("Persona","Persona creada sin edad específica. Edad por defecto 0")
    }

}