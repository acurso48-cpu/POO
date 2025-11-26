package com.julian.poo.examples

//1. Clase básica y propiedades
class Coche (val marca : String, var velocidad : Int = 0){
    fun acelerar(incremento : Int){
        velocidad += incremento
    }
 }