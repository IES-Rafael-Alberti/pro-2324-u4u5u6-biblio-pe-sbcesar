package org.pebiblioteca

class RegistroPrestamo {

    private val prestamosActuales = mutableMapOf<Int, MutableList<String>>()
    private val historialPrestamos = mutableMapOf<Int, MutableList<String>>()

    fun registrarPrestamo(usuario: Int, libro: Libro) {
        if (libro.estado == Estado.DISPONIBLE) {
            prestamosActuales[usuario]?.add("El libro ${libro.titulo} ha sido tomado prestado.")

            historialPrestamos[usuario]?.add("El libro ${libro.titulo} ha sido tomado prestado.")

            GestorBiblioteca().registrarPrestamo(libro)
        } else {
            println("No puedes tomar prestado un libro que no está disponible.")
        }
    }

    fun devolverLibro(libro: Libro, usuario: Int) {
        if (libro.estado == Estado.PRESTADO) {
            prestamosActuales[usuario]?.add("El libro ${libro.titulo} ha sido devuelto")

            historialPrestamos[usuario]?.add("El libro ${libro.titulo} ha sido devuelto")

            GestorBiblioteca().devolverLibro(libro)
        } else {
            println("No puedes devolver un libro que está disponible")
        }
    }

    fun consultarHistorialUsuarioEspecifico(usuario: Int) {
        for ((c,v) in historialPrestamos) {
            if (c == usuario) {
                println(historialPrestamos.values.joinToString { " | " })
            }
        }
    }

    fun cosultarHistorialLibroEspecifico(libro: Libro) {
        TODO("Consultarlo por libro")
    }
}