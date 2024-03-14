package org.pebiblioteca

interface DatosLibro: Prestable {
    val id: Int
    val titulo: String
    val anioPublicacion: Int
    val tematica: String
    var estado: Estado
}