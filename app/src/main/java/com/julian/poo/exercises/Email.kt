package com.julian.poo.exercises

class Email (val direccion : String) {
    init{
     //   require(direccion.contains("@")){"La dirección de email no es válida"}
        require( "@" in direccion) {"La dirección de email no es válida: $direccion"}
    }
}