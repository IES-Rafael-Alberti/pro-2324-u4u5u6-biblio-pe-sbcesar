package org.pebiblioteca

data class Libro(
    override val id: Int,
    override val titulo: String,
    override val anioPublicacion: Int,
    override val tematica: String,
    override var estado: Estado = Estado.DISPONIBLE
) : DatosLibro {
    override fun prestar() {
        TODO("Not yet implemented")
    }

    override fun devolver() {
        TODO("Not yet implemented")
    }
}