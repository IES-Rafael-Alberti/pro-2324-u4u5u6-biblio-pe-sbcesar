package org.pebiblioteca

fun main() {
    val gestorBiblioteca = GestorBiblioteca()

    val libro1 = GestorConsola.crearLibro("Señor de los anillos",2003,"Aventura",Estado.DISPONIBLE)
    val libro2 = GestorConsola.crearLibro("Geronimo Stilton",1999,"Fantasia",Estado.PRESTADO)
    val libro3 = GestorConsola.crearLibro("Caperucita Roja",1987,"Minicuento",Estado.PRESTADO)

    gestorBiblioteca.agregarLibro(libro1)
    gestorBiblioteca.agregarLibro(libro2)
    gestorBiblioteca.agregarLibro(libro3)

    gestorBiblioteca.registrarPrestamo(libro1)
    gestorBiblioteca.registrarPrestamo(libro2)

    gestorBiblioteca.devolverLibro(libro3)
    gestorBiblioteca.devolverLibro(libro1)
}