package com.julian.poo.examples

import android.util.Log
//Singleton
//Solo se instancia un objeto de la clase
// objetc es vez de class

object ConfiguracionApp {
    var temaOscuro : Boolean = true
    fun inicializar(){
        Log.i("Configuracion App", "Configuración de la propidad inicializada")
        if(temaOscuro) Log.i("Configuracion App", "Tu tema es Dark")
        else Log.i("Configuracion App", "Tu tema es Light")
    }
}