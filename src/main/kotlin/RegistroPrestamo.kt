package org.pebiblioteca

class RegistroPrestamo: IGestorPrestamos {

    private val prestamosActuales = mutableMapOf<Int, MutableList<String>>()
    private val historialPrestamos = mutableMapOf<Int, MutableList<String>>()


    override fun registrarDevolucion(libro: Libro, usuario: Int) {
        if (libro.estado == Estado.PRESTADO) {
            prestamosActuales[usuario]?.add("El libro ${libro.titulo} ha sido devuelto")

            historialPrestamos[usuario]?.add("El libro ${libro.titulo} ha sido devuelto")

            GestorBiblioteca().devolverLibro(libro)
        } else {
            println("No puedes devolver un libro que está disponible")
        }
    }

    override fun registrarPrestamo(libro: Libro, usuario: Int) {
        if (libro.estado == Estado.DISPONIBLE) {
            prestamosActuales[usuario]?.add("El libro ${libro.titulo} ha sido tomado prestado.")

            historialPrestamos[usuario]?.add("El libro ${libro.titulo} ha sido tomado prestado.")

            GestorBiblioteca().registrarPrestamo(libro)
        } else {
            println("No puedes tomar prestado un libro que no está disponible.")
        }
    }

    override fun consultarHistorialPorLibro() {
        TODO("Not yet implemented")
    }

    override fun consultarHistorialPorUsuario(usuario: Int) {
        for ((c,v) in historialPrestamos) {
            if (c == usuario) {
                println(historialPrestamos.values.joinToString { " | " })
            }
        }
    }
}