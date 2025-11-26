package com.julian.poo.exercises

import android.util.Log

object AppConfig {
    const val version = "1.0.0"
    var color = "White"

    fun imprimirVersion(){
        Log.d("AppConfig", "La versión de la app es $version")
    }
}