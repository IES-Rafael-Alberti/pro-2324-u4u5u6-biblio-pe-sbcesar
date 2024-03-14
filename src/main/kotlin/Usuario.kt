package org.pebiblioteca

class Usuario(val id: Int, val nombre: String, private val listaLibrosPrestados: MutableList<Libro>) {

    constructor(id: Int, nombre: String) : this(id, nombre, listaLibrosPrestados = mutableListOf<Libro>())

    fun agregarLibro(libro: Libro) {
        if (libro !in listaLibrosPrestados) {
            listaLibrosPrestados.add(libro)
        } else {
            println("Ya esta en la lista")
        }

    }

    fun quitarLibro(libro: Libro) {
        if (libro in listaLibrosPrestados) {
            listaLibrosPrestados.remove(libro)
        } else {
            println("Libro no encontrado")
        }
    }

    fun consultarLibro() {
        listaLibrosPrestados.forEach { libro ->
            println("Libros Prestados:" +
                    "Id: ${libro.id} Titulo: ${libro.titulo} Año de Publicación: ${libro.anioPublicacion} Temática: ${libro.tematica} Estado: ${libro.estado.name}")
        }
    }
}