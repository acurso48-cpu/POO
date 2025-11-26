# Capítulo 1: Fundamentos de clases y objetos en Kotlin (Android Studio)

***
**Autor:** Julián González https://www.linkedin.com/in/juliangm/
**Fecha:** Noviembre de 2025
**Versión:** 1.2
***

La clase es el plano, y el objeto es la instancia concreta. Kotlin simplifica drásticamente la sintaxis para definir ambos, eliminando gran parte del *boilerplate* (código repetitivo) que se encuentra en otros lenguajes.

### 1.0. Conceptos Fundamentales: Propiedades y métodos

Antes de sumergirnos en la sintaxis de Kotlin, es crucial entender los dos componentes principales que definen a un objeto en la POO: las **Propiedades** y los **Métodos**.

#### 1.0.1. Propiedades (atributos)

Una **Propiedad** (o atributo) define el **estado** o las **características** de un objeto. Son los datos que el objeto almacena.

> **Analogía:** Si un objeto es un coche, sus propiedades serían su color, su velocidad actual, su marca y el número de ruedas.

En Kotlin, las propiedades se declaran con `val` (inmutable) o `var` (mutable).

#### 1.0.2. Métodos (funciones)

Un **método** (o función) define el **comportamiento** o las **acciones** que un objeto puede realizar. Son las operaciones que modifican o utilizan el estado del objeto.

> **Analogía:** Si el objeto es un coche, sus métodos serían `acelerar()`, `frenar()`, `encenderMotor()` o `cambiarColor(nuevoColor)`.

**Ejemplo sencillo de objeto (Coche):**

| Componente | Tipo | Descripción |
| --- | --- | --- |
| `color` | Propiedad | Almacena el color actual del coche (Estado). |
| `velocidad` | Propiedad | Almacena la velocidad actual (Estado). |
| `acelerar()` | Método | Aumenta el valor de la propiedad `velocidad` (Comportamiento). |
| `pintar(nuevoColor)` | Método | Cambia el valor de la propiedad `color` (Comportamiento). |

#### 1.0.3. Conceptos de vista en Android: Activity y Fragment

Dado que en este capítulo nos centraremos en la interacción de la POO con la interfaz de usuario, es fundamental comprender el contenedor de diseño que utilizaremos en todos nuestros ejemplos: el **`LinearLayout`**.

El `LinearLayout` es el *ViewGroup* (contenedor de vistas) más simple y fundamental de Android. Su función es organizar sus vistas hijas (como `TextView`, `Button`, `EditText`) en una **única fila (horizontal)** o una **única columna (vertical)**.

| Atributo Clave | Descripción | Valores Típicos |
| --- | --- | --- |
| `android:orientation` | **Define la dirección** en la que se apilan las vistas hijas. Es el atributo más importante del `LinearLayout`. | `vertical` (por defecto) o `horizontal` |
| `android:layout_width` | Define el ancho del `LinearLayout` o de la vista hija. | `match_parent` (ocupa todo el espacio disponible) o `wrap_content` (ocupa solo el espacio necesario). |
| `android:layout_height` | Define la altura del `LinearLayout` o de la vista hija. | `match_parent` o `wrap_content` |
| `android:padding` | Espacio interno entre el borde del `LinearLayout` y sus contenidos. | Valores en `dp` (ej. `16dp`) |
| `android:layout_weight` | **Solo para orientación horizontal.** Permite distribuir el espacio sobrante entre las vistas hijas. Una vista con `weight="1"` ocupará el doble de espacio que una con `weight="0.5"`. | Valores numéricos (ej. `1`) |

**Ejemplo de Estructura Básica:**

```xml
<LinearLayout 
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <!-- Las vistas se apilan de arriba a abajo -->
    <TextView ... />
    <Button ... />
    <EditText ... />

</LinearLayout>
```

Con esta comprensión de `LinearLayout`, podemos enfocarnos en cómo el código Kotlin de POO manipula el estado de estas vistas.

Con esta base, podemos entender cómo se construyen las clases en Kotlin.|}],path:

Para entender los ejemplos de código que siguen, es esencial conocer los dos componentes fundamentales de la interfaz de usuario en Android, que son en sí mismos clases POO que heredan de la jerarquía del sistema:

| Componente | Definición | Analogía Sencilla |
| --- | --- | --- |
| **Activity** | Es el **contenedor principal** de la interfaz de usuario. Representa una única pantalla con la que el usuario puede interactuar (ej. la pantalla de inicio de sesión, la pantalla de ajustes ). Cada Activity tiene un ciclo de vida bien definido (creación, pausa, destrucción). | Es el **marco de la ventana** o la **página completa** de una aplicación web o mobile. |
| **Fragment** | Es un **módulo de comportamiento** o una porción de la interfaz de usuario que se aloja dentro de una Activity. Permite dividir la interfaz de una Activity en partes reutilizables y modulares. | Es un **widget** o un **componente reutilizable** (ej. un mapa, una lista de comentarios) que se puede insertar en diferentes páginas (Activities). |

#### Ciclo de Vida y POO

La interacción entre el código Kotlin de POO y la vista de Android está gobernada por el **Ciclo de Vida** de la `Activity` y el `Fragment`. El ciclo de vida define una serie de métodos que se llaman en momentos específicos (creación, visibilidad, destrucción).

El método más importante para la inicialización de objetos es `onCreate()`.

| Método del Ciclo de Vida | Propósito | Conexión con POO |
| --- | --- | --- |
| `onCreate()` | Se llama cuando el componente es creado por primera vez. Es el lugar ideal para la inicialización de la vista (ej. `setContentView()`) y la creación de objetos POO. | Aquí se inicializan las propiedades `lateinit` (vistas y objetos) y se crean las instancias de las clases POO que la `Activity` utilizará. |
| `onStart()` / `onResume()` | El componente se hace visible y está listo para la interacción. | Se utiliza para iniciar procesos que requieren que la interfaz esté activa (ej. iniciar animaciones, conectar a servicios). |
| `onPause()` / `onStop()` | El componente deja de ser el foco o se hace invisible. | Se utiliza para liberar recursos que no son necesarios en segundo plano (ej. detener animaciones, guardar datos no persistentes). |
| `onDestroy()` | El componente es destruido y liberado de la memoria. | Se utiliza para limpiar recursos finales y evitar fugas de memoria (ej. cancelar corrutinas, cerrar bases de datos). |

Esta estructura de ciclo de vida es la razón por la que la POO en Android se centra en la **gestión del estado** y la **liberación de recursos** en los momentos adecuados.

Con esta base, podemos entender cómo se construyen las clases en Kotlin.

### 1.1. Declaración de clases y propiedades

En Kotlin, una clase se declara con la palabra clave `class`. Por defecto, las clases son **finales**, lo que significa que no pueden ser heredadas a menos que se marquen explícitamente con `open` (ver Capítulo 2) [1].

#### 1.1.1. Propiedades: `val` vs `var`

Las propiedades de una clase definen su estado. Kotlin distingue entre propiedades inmutables (`val`) y mutables (`var`), fomentando la inmutabilidad para un código más seguro y predecible, un principio crucial en el desarrollo concurrente de Android.

| Palabra Clave | Tipo de Propiedad | Mutabilidad | Uso Recomendado en Android |
| --- | --- | --- | --- |
| `val` | Valor (Value) | Inmutable (solo lectura) | Modelos de datos (`data class`), IDs, constantes, referencias a objetos que no deben cambiar. |
| `var` | Variable (Variable) | Mutable (lectura y escritura) | Propiedades de estado que cambian con el tiempo (ej. `velocidad`, `contador`), campos de formularios. |

**Ejemplo básico de Clase:**

```kotlin
class Usuario(val id: Int, var nombre: String) {
    // id es inmutable (val)
    // nombre es mutable (var)
}

fun main() {
    val usuario = Usuario(1, "Alice")
    // usuario.id = 2 // Error de compilación: val no puede ser reasignado
    usuario.nombre = "Alicia" // Correcto: var puede ser reasignado
}
```

#### 1.1.2. Inicialización tardía (`lateinit`)

En Kotlin, las propiedades no nulas deben ser inicializadas en el momento de su declaración o en el constructor. Sin embargo, en el desarrollo de Android, a menudo se declaran propiedades que se inicializan más tarde, típicamente en el método `onCreate` de una `Activity` o `Fragment`, o a través de un mecanismo de inyección de dependencias.

Para estos casos, se utiliza el modificador `lateinit` (del inglés *late initialization*).

> **Definición:** `lateinit` permite declarar una propiedad `var` no nula sin inicializarla inmediatamente, prometiendo al compilador que será inicializada antes de ser utilizada por primera vez.

**Características clave de ****`lateinit`****:**

1. **Solo para ****`var`****:** No se puede usar con propiedades `val` (que son inmutables).

1. **Solo para tipos no primitivos:** No se puede usar con tipos primitivos de Kotlin (`Int`, `Boolean`, `Double`, etc.), ya que estos siempre tienen un valor por defecto.

1. **Contexto de Android:** Es fundamental para inicializar vistas (`TextView`, `Button`, etc.) y objetos de inyección de dependencias que dependen del ciclo de vida de Android.

**Ejemplo de uso en Android:**

```kotlin
class MainActivity : AppCompatActivity() {
    
    // Declaración de propiedades de vista sin inicialización inmediata
    private lateinit var tvNombreUsuario: TextView
    private lateinit var btnCambiarNombre: Button
    
    // También se usa para objetos POO que se inicializan en onCreate
    private lateinit var usuario: Usuario 

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        // Inicialización tardía de las propiedades
        tvNombreUsuario = findViewById(R.id.tv_nombre_usuario)
        btnCambiarNombre = findViewById(R.id.btn_cambiar_nombre)
        usuario = Usuario(id = 101, nombre = "Manuel")
        
        // A partir de aquí, las propiedades pueden ser usadas de forma segura
        tvNombreUsuario.text = "Bienvenido, ${usuario.nombre}"
    }
}
```

**Verificación de inicialización (opcional):**

Antes de acceder a una propiedad `lateinit`, se puede verificar si ha sido inicializada utilizando la reflexión de Kotlin:

```kotlin
if (::tvNombreUsuario.isInitialized) {
    // Es seguro usar tvNombreUsuario
}
```

El uso de `private lateinit var` en el manual, como en los ejemplos de la `Activity`, sigue esta práctica estándar de Android para manejar las referencias a vistas y objetos de ciclo de vida.

**Ejemplo práctico en Android (integración con vista XML):**

Este ejemplo ilustra cómo un objeto de datos inmutable (`val`) se utiliza para inicializar una vista y cómo una propiedad mutable (`var`) se actualiza a través de la interacción del usuario.

**1. Archivo ****`activity_main.xml`**** (****`LinearLayout`****):**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout 
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <TextView
        android:id="@+id/tv_nombre_usuario"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="20sp"
        android:textStyle="bold"
        android:text="Nombre: [Cargando...]" />

    <Button
        android:id="@+id/btn_cambiar_nombre"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="8dp"
        android:text="Cambiar Nombre" />

</LinearLayout>
```

**2. Archivo ****`MainActivity.kt`****:**

```kotlin
class Usuario(val id: Int, var nombre: String    )

class MainActivity : AppCompatActivity() {
    
    private lateinit var usuario: Usuario
    private lateinit var tvNombreUsuario: TextView
    private lateinit var btnCambiarNombre: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        // Inicialización de Vistas
        tvNombreUsuario = findViewById(R.id.tv_nombre_usuario)
        btnCambiarNombre = findViewById(R.id.btn_cambiar_nombre)

        // Creación del Objeto POO
        usuario = Usuario(id = 101, nombre = "Manuel")
        
        // Mostrar la propiedad 'val' (id) y 'var' (nombre)
        tvNombreUsuario.text = "ID: ${usuario.id} | Nombre: ${usuario.nombre}"

        // Interacción para modificar la propiedad 'var'
        btnCambiarNombre.setOnClickListener {
            // Modificamos la propiedad mutable 'var' del objeto POO
            usuario.nombre = "Manuel (Actualizado)"
            
            // Reflejamos el cambio en la Vista XML
            tvNombreUsuario.text = "ID: ${usuario.id} | Nombre: ${usuario.nombre}"
        }
    }
}
```

Este ejemplo demuestra cómo la inmutabilidad de `id` y la mutabilidad de `nombre` se reflejan directamente en la lógica de la `Activity` que interactúa con los elementos de la vista.

### 1.1.3. Aclaración clave: Casting vs. Conversión

Un error común al empezar es confundir el **casting** (conversión de tipo) con la **conversión de valor**. Ambos transforman un tipo en otro, pero lo hacen de maneras fundamentalmente diferentes.

#### Casting (`as`, `as?`)

El casting es decirle al compilador: *"Confía en mí, sé que este objeto, aunque lo tienes referenciado como un tipo `A`, es en realidad una instancia de un tipo `B` más específico"*.

*   **No crea un nuevo objeto.** Simplemente cambia la "etiqueta" (el tipo de la referencia) con la que manejas el objeto existente.
*   Requiere una relación de herencia ("es un"). Por ejemplo, un `TextView` **es un** `View`.
*   **Ejemplo en Android:** `findViewById` devuelve un objeto de tipo `View`. Para acceder a propiedades específicas de `TextView` como `.text`, necesitas hacer un casting.

```kotlin
// findViewById devuelve un View genérico
val vista: View = findViewById(R.id.tv_nombre_usuario)

// Casting inseguro: Falla con una excepción si la vista no es un TextView
val textViewInseguro = vista as TextView 
textViewInseguro.text = "Hola"

// Casting seguro: Devuelve null si la vista no es un TextView (preferido)
val textViewSeguro = vista as? TextView
textViewSeguro?.text = "Hola de nuevo" // El '?' es necesario
```

#### Conversión de Valor (`.toInt()`, `.toString()`, etc.)

La conversión de valor crea un **objeto completamente nuevo** de un tipo diferente, basado en el contenido del objeto original.

*   **Crea un nuevo objeto** en memoria.
*   No requiere una relación de herencia. Se basa en el valor. Por ejemplo, un `String` no "es un" `Int`, pero el valor `"123"` puede **convertirse** en el número `123`.
*   **Ejemplo en Android:** Obtener un número de un `EditText`.

```kotlin
val etEdad: EditText = findViewById(R.id.et_edad)
val textoEdad: String = etEdad.text.toString() // El Editable se convierte a String

try {
    // La conversión puede fallar (ej. si el texto es "abc")
    val edadNumerica: Int = textoEdad.toInt() 
    println("El próximo año tendrás ${edadNumerica + 1} años.")
} catch (e: NumberFormatException) {
    println("El valor introducido no es un número válido.")
}
```

| Característica | Casting (`as`, `as?`) | Conversión de Valor (`.toInt()`) |
| :--- | :--- | :--- |
| **Propósito** | Tratar un objeto como si fuera de otro tipo compatible. | Crear un **nuevo** objeto de un tipo diferente. |
| **Objeto** | El objeto original no cambia. Se cambia la referencia. | Se crea un nuevo objeto en memoria. |
| **Relación** | Requiere una relación "es-un" (herencia). | No requiere herencia. Se basa en el valor. |
| **Fallo** | Lanza `ClassCastException` o devuelve `null`. | Lanza `NumberFormatException` (u otra excepción). |
| **Ejemplo** | `val tv = view as TextView` | `val num = "123".toInt()` |

### 1.2. Constructores y bloques de inicialización

Kotlin maneja la inicialización de objetos a través de dos tipos de constructores: el primario y el secundario.

#### 1.2.1. El Constructor primario

El constructor primario es la forma más concisa de inicializar una clase y se declara directamente en el encabezado de la clase.

```kotlin
// El constructor primario define las propiedades directamente
class Coche(val marca: String, val modelo: String, var velocidad: Int = 0)
```

Si una propiedad se declara con `val` o `var` en el constructor primario, se convierte automáticamente en una propiedad de la clase. Si se omite, el parámetro solo está disponible dentro de los bloques de inicialización (`init`) [2].

#### 1.2.2. Bloques de inicialización (`init`)

Los bloques `init` se ejecutan inmediatamente después de que se llama al constructor primario y antes de que se ejecute cualquier constructor secundario. Se utilizan para contener lógica de inicialización o validación.

**Ejemplo Básico de Validación:**

```kotlin
class Persona(val nombre: String, edad: Int) {
    val edadValidada: Int

    init {
        // Validación: Se asegura que la edad no sea negativa. Si lo es, lanza una excepción.
        require(edad >= 0) { "La edad no puede ser negativa." }
        this.edadValidada = edad
        println("Objeto Persona inicializado con éxito.")
    }
}
```

**Ejemplo Avanzado en Android: Validación de Formulario con **`init`** y ****`LinearLayout`**

Este ejemplo ilustra cómo el bloque `init` puede ser utilizado para validar datos que provienen de un formulario de Android (simulado por un constructor secundario), asegurando que el objeto POO solo se cree con datos válidos.

**1. Clase POO con Validación en ****`init`****:**

```kotlin
class Credenciales(val usuario: String, val clave: String) {
    
    init {
        // El bloque init valida las propiedades del constructor primario
        require(usuario.length >= 4) { "El usuario debe tener al menos 4 caracteres." }
        require(clave.length >= 6) { "La clave debe tener al menos 6 caracteres." }
    }

    // Constructor secundario para simular la recepción de datos de la vista
    constructor(datosVista: Map<String, String>) : this(
        usuario = datosVista["usuario"] ?: "",
        clave = datosVista["clave"] ?: ""
    )
}
```

**2. Archivo ****`activity_login.xml`**** (****`LinearLayout`****):**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout 
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <EditText
        android:id="@+id/et_usuario"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Usuario (mín. 4 caracteres  )" />

    <EditText
        android:id="@+id/et_clave"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="8dp"
        android:hint="Clave (mín. 6 caracteres)"
        android:inputType="textPassword" />

    <Button
        android:id="@+id/btn_login"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="16dp"
        android:text="Iniciar Sesión" />

    <TextView
        android:id="@+id/tv_mensaje"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="16dp"
        android:textColor="@android:color/holo_red_dark" />

</LinearLayout>
```

**3. Archivo ****`LoginActivity.kt`****:**

```kotlin
class LoginActivity : AppCompatActivity() {
    
    private lateinit var etUsuario: EditText
    private lateinit var etClave: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvMensaje: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        
        etUsuario = findViewById(R.id.et_usuario)
        etClave = findViewById(R.id.et_clave)
        btnLogin = findViewById(R.id.btn_login)
        tvMensaje = findViewById(R.id.tv_mensaje)

        btnLogin.setOnClickListener {
            val datosVista = mapOf(
                "usuario" to etUsuario.text.toString(),
                "clave" to etClave.text.toString()
            )
            
            try {
                // Intentamos crear el objeto POO. Si la validación falla, lanza excepción.
                val credenciales = Credenciales(datosVista)
                tvMensaje.text = "¡Credenciales Válidas! Usuario: ${credenciales.usuario}"
                tvMensaje.setTextColor(ContextCompat.getColor(this, android.R.color.holo_green_dark))
            } catch (e: IllegalArgumentException) {
                // Capturamos la excepción lanzada por el bloque 'init'
                tvMensaje.text = "Error de Validación: ${e.message}"
                tvMensaje.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_dark))
            }
        }
    }
}
```

Este ejemplo demuestra cómo el bloque `init` impone reglas de negocio en el momento de la creación del objeto, delegando la responsabilidad de la validación a la clase POO y simplificando la lógica de la `Activity`.

#### 1.2.3. Constructores secundarios (Ejemplo Complejo: Deserialización de Datos)

Las clases pueden tener uno o más constructores secundarios, declarados con la palabra clave `constructor`. Un constructor secundario debe delegar (llamar) al constructor primario de la clase, ya sea directa o indirectamente, utilizando la palabra clave `this()` [2].

Un caso de uso avanzado en Android es la creación de un objeto POO a partir de un formato de datos externo (como JSON o un `Bundle` de Android), donde el constructor secundario se encarga de la lógica de deserialización.

**Ejemplo:** Clase `ItemLista` que puede crearse a partir de datos de red (JSON simulado) o con valores por defecto.

```kotlin
// Objeto de datos que representa un elemento de una lista (ej. RecyclerView)
class ItemLista(val id: Int, val titulo: String, val descripcion: String, val esDestacado: Boolean) {

    // Constructor Primario (el más completo)
    // ...

    // Constructor Secundario para inicializar desde un mapa de datos (simulando JSON)
    constructor(dataMap: Map<String, Any>) : this(
        id = dataMap["id"] as? Int ?: 0,
        titulo = dataMap["titulo"] as? String ?: "Sin Título",
        descripcion = dataMap["descripcion"] as? String ?: "Sin descripción",
        esDestacado = dataMap["destacado"] as? Boolean ?: false
    ) {
        // Lógica de validación o logging después de la deserialización
        println("ItemLista creado desde Map. Título: $titulo")
    }
}

// Uso en una Activity (simulando la recepción de datos de red)
fun simularRecepcionDeDatos() {
    val datosRed = mapOf(
        "id" to 42,
        "titulo" to "Artículo Destacado",
        "descripcion" to "Este es un artículo importante.",
        "destacado" to true
    )

    val item = ItemLista(datosRed)
    // item.titulo ahora es "Artículo Destacado"
}
```

### 1.3. Propiedades avanzadas: Getters, Setters y Backing Fields

Kotlin genera automáticamente los métodos *getter* y *setter* para las propiedades (`val` solo tiene *getter*, `var` tiene ambos). Sin embargo, podemos personalizar este comportamiento para implementar lógica de negocio o validación.

#### 1.3.1. Getters y Setters personalizados (Ejemplo Complejo: Propiedad Calculada para Vista)

Podemos definir un *getter* o *setter* personalizado para una propiedad. Esto es útil para:

1. **Propiedades Calculadas:** El *getter* calcula el valor en lugar de almacenarlo.

1. **Validación:** El *setter* valida el nuevo valor antes de asignarlo.

**Ejemplo:** Una clase `GestorDeProgreso` que calcula dinámicamente el estado de una tarea.

```kotlin
class GestorDeProgreso(private val maxPasos: Int) {
    private var pasosActuales: Int = 0

    // Propiedad Calculada: El getter calcula el porcentaje de progreso
    val progresoPorcentaje: Int
        get() = (pasosActuales.toDouble() / maxPasos.toDouble() * 100).toInt()

    // Propiedad con Setter Personalizado: Actualiza el estado interno y valida
    var pasosCompletados: Int
        get() = pasosActuales
        set(value) {
            if (value >= 0 && value <= maxPasos) {
                pasosActuales = value
                println("Progreso actualizado a $progresoPorcentaje%")
            } else {
                println("Advertencia: Valor fuera de rango.")
            }
        }
}
```

**Ejemplo Práctico en Android (Propiedad calculada con ****`LinearLayout`****):**

Este ejemplo utiliza un `LinearLayout` para mostrar el progreso de una tarea mediante un `TextView` que refleja el progreso calculado por la propiedad `progresoPorcentaje`.

**1. Archivo ****`activity_progress.xml`**** (****`LinearLayout`****):**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout 
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <TextView
        android:id="@+id/tv_progreso_titulo"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Estado de la Tarea:"
        android:textSize="18sp"
        android:textStyle="bold" />

    <TextView
        android:id="@+id/tv_progreso_valor"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="8dp"
        android:text="Progreso: 0% (0/5    )" />

    <Button
        android:id="@+id/btn_avanzar_paso"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="16dp"
        android:text="Avanzar un Paso" />

</LinearLayout>
```

**2. Archivo ****`ProgressActivity.kt`****:**

```kotlin
class ProgressActivity : AppCompatActivity() {
    
    private val gestor = GestorDeProgreso(maxPasos = 5) // Máximo de 5 pasos
    private lateinit var tvProgresoValor: TextView
    private lateinit var btnAvanzarPaso: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress)
        
        tvProgresoValor = findViewById(R.id.tv_progreso_valor)
        btnAvanzarPaso = findViewById(R.id.btn_avanzar_paso)

        // Inicializar la vista
        actualizarVista()

        btnAvanzarPaso.setOnClickListener {
            // Modificamos la propiedad 'pasosCompletados' del objeto POO
            gestor.pasosCompletados += 1
            
            // La vista se actualiza con el valor calculado por el getter
            actualizarVista()
            
            if (gestor.pasosCompletados == gestor.maxPasos) {
                btnAvanzarPaso.isEnabled = false
            }
        }
    }

    private fun actualizarVista() {
        tvProgresoValor.text = "Progreso: ${gestor.progresoPorcentaje}% (${gestor.pasosCompletados}/${gestor.maxPasos})"
    }
}
```

#### 1.3.2. El Backing Field (`field`)

El **Backing Field** es el campo de memoria real que almacena el valor de una propiedad. En Kotlin, este campo no es directamente visible, pero se puede acceder a él dentro de un *getter* o *setter* personalizado usando el identificador `field`.

> **Importante:** Si una propiedad no utiliza el *getter* o *setter* por defecto, o si no se accede a ella a través del identificador `field`, Kotlin no genera un *backing field* para ahorrar memoria. Esto ocurre comúnmente en propiedades calculadas.

**Regla de Oro:** Dentro de un *getter* o *setter* personalizado, **siempre** se debe usar `field` para acceder al valor de la propiedad, para evitar una recursión infinita.

### 1.4. Encapsulamiento y modificadores de Visibilidad (Ejemplo Complejo: Gestión de Lista Dinámica)

El **Encapsulamiento** es el principio de ocultar los detalles de implementación de un objeto, exponiendo solo una interfaz controlada. Kotlin implementa esto a través de modificadores de visibilidad.

| Modificador | Alcance de Visibilidad | Equivalente en Java (Aprox.) | Uso Típico en Android |
| --- | --- | --- | --- |
| `public` | Por defecto. Visible en todas partes. | `public` | Métodos de interfaz pública (`onClick`), propiedades de acceso general. |
| `private` | Visible solo dentro de la clase o archivo que lo contiene. | `private` | Lógica interna, estado mutable que no debe ser modificado externamente. |
| `protected` | Visible dentro de la clase y sus subclases. | `protected` | Miembros destinados a ser extendidos o modificados por subclases. |
| `internal` | Visible dentro del mismo módulo (ej. el módulo `app` de Android). | (No tiene equivalente directo) | Comunicación entre clases dentro del mismo módulo de la aplicación. |

**Ejemplo de Encapsulamiento con Lista Dinámica en ****`LinearLayout`****:**

El encapsulamiento es crucial para proteger la lista de datos. La `Activity` o `Fragment` no debe poder modificar la lista directamente sin pasar por los métodos de la clase POO, lo que garantiza que la lógica de negocio se ejecute.

**1. Clase POO Encapsulada (****`GestorDeTareas`****):**

```kotlin
class GestorDeTareas {
    // 1. La lista de datos es privada y mutable (solo el objeto puede modificarla)
    private val _tareas = mutableListOf("Comprar leche", "Estudiar POO", "Hacer ejercicio")

    // 2. El getter expone una copia inmutable de la lista (solo lectura)
    val tareas: List<String>
        get() = _tareas.toList() // toList() devuelve una copia inmutable

    // 3. Método público para modificar el estado interno de forma controlada
    fun agregarTarea(tarea: String) {
        if (tarea.isNotBlank()) {
            _tareas.add(tarea)
        }
    }

    fun eliminarTarea(index: Int) {
        if (index in _tareas.indices) {
            _tareas.removeAt(index)
        }
    }
}
```

**2. Archivo ****`activity_tareas.xml`**** (****`LinearLayout`****):**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout 
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <EditText
        android:id="@+id/et_nueva_tarea"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Nueva Tarea" />

    <Button
        android:id="@+id/btn_agregar_tarea"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="8dp"
        android:text="Agregar Tarea" />

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="16dp"
        android:text="Lista de Tareas:"
        android:textSize="18sp"
        android:textStyle="bold" />

    <!-- Contenedor donde se añadirán dinámicamente los TextViews de las tareas -->
    <LinearLayout
        android:id="@+id/ll_contenedor_tareas"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical" />

</LinearLayout>
```

**3. Archivo ****`TareaActivity.kt`****:**

```kotlin
class TareaActivity : AppCompatActivity(    ) {
    private val gestorDeTareas = GestorDeTareas()
    private lateinit var etNuevaTarea: EditText
    private lateinit var btnAgregarTarea: Button
    private lateinit var llContenedorTareas: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tareas)
        
        etNuevaTarea = findViewById(R.id.et_nueva_tarea)
        btnAgregarTarea = findViewById(R.id.btn_agregar_tarea)
        llContenedorTareas = findViewById(R.id.ll_contenedor_tareas)

        // Inicializar la vista con las tareas iniciales
        actualizarListaTareas()

        btnAgregarTarea.setOnClickListener {
            val nuevaTarea = etNuevaTarea.text.toString()
            
            // La Activity llama al método público del GestorDeTareas
            gestorDeTareas.agregarTarea(nuevaTarea)
            
            // Reflejamos el cambio en la Vista XML
            actualizarListaTareas()
            etNuevaTarea.text.clear()
        }
    }

    private fun actualizarListaTareas() {
        llContenedorTareas.removeAllViews() // Limpiar el contenedor
        
        // Iteramos sobre la lista inmutable obtenida del getter
        gestorDeTareas.tareas.forEachIndexed { index, tarea ->
            val tvTarea = TextView(this).apply {
                text = "${index + 1}. $tarea"
                textSize = 16f
                setPadding(0, 4, 0, 4)
            }
            llContenedorTareas.addView(tvTarea)
        }
    }
}
```

Este ejemplo avanzado muestra cómo el encapsulamiento protege los datos de la lista y obliga a la `Activity` a interactuar con la clase POO de forma controlada, mientras que la vista se actualiza dinámicamente usando solo `LinearLayout`.

### Referencias (Capítulo 1)

[1]: https://kotlinlang.org/docs/classes.html "Classes | Kotlin Documentation. (2025 )."

[2]: https://medium.com/@dawinderapps/android-interview-questions-3-constructors-in-kotlin-primary-secondary-constructor-e5bfb4e252d7 "Constructors in Kotlin — Primary & Secondary. (2024 )."

[3]: https://kotlinlang.org/docs/properties.html "Properties | Kotlin Documentation. (2025 )."

[4]: https://medium.com/@ajay_00/understanding-getters-and-setters-in-kotlin-fb6d83face15 "Understanding Getters and Setters in Kotlin. (2024 )."

[5]: https://blog.adamcameron.me/2022/09/kotlin-abstract-classes-backing.html "Kotlin: abstract classes, backing fields/properties, lateinit, and .... (2022 )."

