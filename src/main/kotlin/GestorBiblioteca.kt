package org.pebiblioteca

/**
 * Clase GestorBiblioteca que se encarga de gestionar la biblioteca
 */
class GestorBiblioteca {
    private val catalogo = emptyList<Libro>()
    private val registroPrestamo = emptyList<String>()

    /**
     * Se encarga de añadir un libro al catálogo.
     *
     * @param libro Libro : El libro que deseas añadir
     */
    fun agregarLibro(libro: Libro) {
        if (libro !in catalogo) {
            catalogo.addLast(libro)
        } else {
            println("Libro no encontrado")
        }
    }

    /**
     * Se encarga de eliminar un libro del catálogo.
     *
     * @param libro Libro : El libro que deseas eliminar
     */
    fun eliminarLibro(libro: Libro) {
        if (catalogo.contains(libro)) {
            val indice = catalogo.indexOf(libro)
            catalogo.drop(indice)
        } else {
            println("Libro no encontrado")
        }
    }

    /**
     * Cambia el estado del libro a prestado si está disponible. Agrega al registro la acción realizada.
     *
     * @param libro Libro : El libro que quieres tomar prestado
     */
    fun registrarPrestamo(libro: Libro) {
        if (catalogo.contains(libro) && libro.estado == Estado.DISPONIBLE) {
            libro.estado = Estado.PRESTADO
            registroPrestamo.addLast("El libro ${libro.titulo} ha sido prestado.")
        } else {
            println("El libro no está en el catálogo o no está disponible.")
        }
    }

    /**
     * Devuelve el libro al catálogo. Cambia su estado a disponible y registra la acción.
     *
     * @param libro Libro: El libro que deseas devolver.
     */
    fun devolverLibro(libro: Libro) {
        if (catalogo.contains(libro) && libro.estado == Estado.PRESTADO) {
            libro.estado = Estado.DISPONIBLE
            registroPrestamo.addLast("El libro ${libro.titulo} ha sido devuelto.")
        } else {
            println("El libro es falso")
        }
    }

    /**
     * Consulta si el libro está disponible o no.
     *
     * @param libro Libro : El libro que deseas ver su disponibilidad
     */
    fun consultarDisponibilidad(libro: Libro) {
        if (libro in catalogo) {
            println("El estado del libro ${libro.titulo} es ${libro.estado.name}")
        }
    }

    /**
     * Muestra la info del catálogo
     */
    fun mostrarInfo(): String {
        return """
            *** TODOS LOS LIBROS ***
            ${catalogo.forEach { libro -> 
                println(libro)
            }}
               *** DISPONIBLES ***
            ${catalogo.forEach { libro -> 
                if (libro.estado == Estado.DISPONIBLE) {
                    println(libro)
                }
            }}
                *** PRESTADOS ***
            ${catalogo.forEach { libro -> 
                if (libro.estado == Estado.PRESTADO) {
                    println(libro)
                }
            }}
        """.trimIndent()
    }
}