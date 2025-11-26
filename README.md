# Proyecto de POO en Kotlin para Android

Este proyecto es una colección de ejemplos y ejercicios prácticos del "Curso Android 2025", diseñado para ilustrar los conceptos fundamentales de la Programación Orientada a Objetos (POO) utilizando Kotlin en el entorno de Android Studio.

## 🚀 Conceptos Abordados

El código fuente contiene demostraciones de los siguientes principios y características de la POO:

-   **Clases y Objetos**: Creación y uso de clases como `Coche` y `Persona` para modelar entidades del mundo real.
-   **Constructores**: Uso de constructores primarios y secundarios para inicializar objetos con diferentes conjuntos de datos.
-   **Propiedades y Métodos**: Definición de atributos (variables) y comportamientos (funciones) para las clases.
-   **Bloques de Inicialización (`init`)**: Ejecución de código de validación o configuración en el momento de la creación de un objeto (ej. clase `Usuario`).
-   **Data Classes**: Uso de clases de datos (`Producto`, `Libro`) para simplificar el manejo de clases que solo almacenan estado. Se exploran métodos autogenerados como `copy()`, `toString()` y la desestructuración de componentes.
-   **Objects (Singletons)**: Implementación del patrón Singleton a través de la palabra clave `object` para gestionar configuraciones o estados globales (`ConfiguracionApp`, `AppConfig`).
-   **Manejo de Excepciones**: Captura de errores en tiempo de ejecución, como `IllegalArgumentException`, para crear código más robusto.
-   **Componentes de Android**:
    -   Interacción básica con `Activity` como pantalla principal de la aplicación.
    -   Uso de `Button` para disparar eventos.
    -   Navegación entre diferentes `Activities` mediante `Intent`.
    -   Registro de información y depuración con `Log`.

## 📂 Estructura del Proyecto

El código está organizado en los siguientes paquetes para facilitar su estudio:

-   `com.julian.poo.main`: Contiene la `MainActivity` que sirve como punto de entrada y ejecuta los diferentes ejemplos.
-   `com.julian.poo.examples`: Incluye clases de demostración como `Coche`, `Persona`, `Producto`, `Usuario` y `ConfiguracionApp`.
-   `com.julian.poo.exercises`: Contiene ejercicios prácticos para reforzar el aprendizaje, como `Articulo`, `Cuadrado`, `Email` y `Libro`.
-   `com.julian.poo.chapter1`: Actividades de ejemplo relacionadas con los capítulos del curso.

## 🛠️ Cómo Empezar

1.  **Clona o descarga** este repositorio en tu máquina local.
2.  **Abre el proyecto** con Android Studio.
3.  **Ejecuta la aplicación** en un emulador o en un dispositivo físico.
4.  **Revisa Logcat** en Android Studio para ver los resultados de la ejecución de los ejemplos. Puedes filtrar por tags como `Coche`, `Persona`, `Usuario`, `Producto`, etc. para analizar el comportamiento de cada clase.

