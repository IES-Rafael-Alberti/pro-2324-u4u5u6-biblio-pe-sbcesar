package org.pebiblioteca

object GestorConsola {
    private var id = 0

    fun generadorId(): Int {
        id++
        return id
    }

    fun crearLibro(nombreLibro: String, anioPublicacion: Int, tematica: String, estado: Estado): Libro {
        return Libro(id, nombreLibro, anioPublicacion, tematica, estado)
    }

    fun mostrarInfoLibro() {
        println(GestorBiblioteca().mostrarInfo())
    }
}