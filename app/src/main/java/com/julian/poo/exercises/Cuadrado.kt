package com.julian.poo.exercises

class Cuadrado (val lado : Double) {
    fun imprimirArea() : Double{
        println("El area del cuadrado es ${lado * lado}")
        return lado * lado
    }
}