package com.julian.poo.examples

// data class
data class Producto (val id: Int, val nombre : String, val precio: Double)

//Por defecto los data class, crean automáticamente una serie de métodos.

//equals() para comparar dos objetos
//toString()
//copy() Crear una copia del objeto
//componentN(): Permite la decontrucción de un objeto. (val (id, nombre, precio) = producto

//Es es la elección estandard para modelos de datos (APIs, BBDD, ...)