package org.pebiblioteca

data class Libro(
    val id: Int,
    val titulo: String,
    val anioPublicacion: Int,
    val tematica: String,
    var estado: Estado = Estado.DISPONIBLE
)