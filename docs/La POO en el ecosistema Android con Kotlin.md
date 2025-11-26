# La POO en el ecosistema Android con Kotlin

***
**Autor:** Julián González https://www.linkedin.com/in/juliangm/
**Fecha:** Noviembre de 2025
**Versión:** 1.3 
***

Bienvenido a este manual de Programación Orientada a Objetos (POO) con Kotlin, 
enfocado específicamente en el desarrollo de aplicaciones para Android.

El objetivo de este documento es doble: primero, establecer una base sólida en los principios 
de la POO, y segundo, demostrar cómo estos principios se aplican de manera práctica y eficiente en el ecosistema Android, utilizando Kotlin como lenguaje principal. A lo largo de los capítulos, no solo exploraremos la teoría, sino que la conectaremos directamente con componentes esenciales de Android como `Activity`, `Fragment`, `LinearLayout`, `ConstraintLayout` y `RecyclerView`, culminando en la construcción de una aplicación funcional de ejemplo.

Este manual está diseñado para estudiantes y desarrolladores que se inician en la POO y buscan entender su relevancia en el desarrollo de aplicaciones modernas.

***

# Índice completo

## Capítulo 0: Introducción a la POO y su contexto

*   **0.1. El Origen de la POO: Una solución a la complejidad**
    *   0.1.1. El problema de la Programación Estructurada
    *   0.1.2. El nacimiento del objeto
*   **0.2. ¿Por Qué POO? Ventajas vlave sobre otros paradigmas**
    *   0.2.1. El ejemplo de la herencia en Android

## Capítulo 1: Fundamentos de clases y objetos en Kotlin

*   **1.0. Conceptos fundamentales**
    *   1.0.1. Propiedades (atributos)
    *   1.0.2. Métodos (comportamiento)
    *   1.0.3. Conceptos de vista en Android: Activity y Fragment
        *   Ciclo de vida y POO
    *   1.0.4. Profundizando en la vista: LinearLayout
*   **1.1. Clases y Objetos**
    *   1.1.1. Declaración de clases
    *   1.1.2. Inicialización tardía (`lateinit`)
*   **1.2. Constructores y bloques de inicialización**
    *   1.2.1. Constructor primario
    *   1.2.2. Bloque `init`
    *   1.2.3. Constructor secundario
    *   *Ejemplo Práctico:* Validación de formulario con `init` y `LinearLayout`
*   **1.3. Propiedades avanzadas: Getters y Setters**
    *   1.3.1. Getters y Setters personalizados
*   **1.4. Encapsulamiento y modificadores de visibilidad**
    *   *Ejemplo Práctico:* Encapsulamiento de datos en una lista

## Capítulo 2: Herencia, polimorfismo y abstracción

*   **2.0. Profundizando en la vista: ConstraintLayout**
*   **2.1. Herencia de clases**
    *   2.1.1. Clases `open` y `final`
*   **2.2. Polimorfismo**
    *   2.2.1. Sobreescritura de métodos (`override`)
*   **2.3. Abstracción**
    *   2.3.1. Clases abstractas
    *   2.3.2. Interfaces
*   *Ejemplo práctico unificado:* Aplicación de gestión de recetas (Herencia, polimorfismo y abstracción con `ConstraintLayout`)

## Capítulo 3: Clases especiales de Kotlin para POO

*   **3.1. `data class` (Clases de datos)**
*   **3.2. `object` (Objetos Singleton)**
*   **3.3. `sealed class` (Clases selladas)**
*   *Ejemplo práctico unificado:* Aplicación de cursos del CRN de Getafe (Uso de `data class`, `object`, `sealed class` y `RecyclerView`)

## Capítulo 4: Delegación y propiedades Delegadas

*   **4.1. Delegación de clases (`by`)**
    *   4.1.1. Ejemplo integrado: Logging delegado en el 'Gestor de cursos'
*   **4.2. Propiedades delegadas (`by`)**
    *   4.2.1. Propiedad delegada estándar: `lazy` para formateadores
    *   4.2.2. Propiedad delegada en Android: `by viewModels()`

## Referencias

*   Lista de referencias bibliográficas y enlaces a la documentación oficial de Kotlin y Android.
