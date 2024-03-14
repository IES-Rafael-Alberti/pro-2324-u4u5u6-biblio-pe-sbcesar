package org.pebiblioteca

interface IGestorPrestamos {
    fun registrarPrestamo(libro: Libro, usuario: Int)
    fun registrarDevolucion(libro: Libro, usuario: Int)
    fun consultarHistorialPorUsuario(usuario: Int)
    fun consultarHistorialPorLibro()
}