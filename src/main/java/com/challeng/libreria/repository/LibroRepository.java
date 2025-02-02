package com.challeng.libreria.repository;


import com.challeng.libreria.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface LibroRepository extends JpaRepository<Libro, Long> {

    Libro findByTituloIgnoreCase(String titulo);


    @Query("SELECT l FROM Libro l JOIN FETCH l.autores a WHERE a.nombre = :nombre")
    List<Libro> encontrarPorAutor(String nombre);

    @Query("SELECT l FROM Libro l JOIN FETCH l.autores")
    List<Libro> encontrarTodoConAutores();

    // List<Libro> findByLenguajes (String idioma);

    @Query("SELECT l FROM Libro l LEFT JOIN FETCH l.autores WHERE l.lenguajes = :codigoIdioma")
    List<Libro> findByLenguajes(String codigoIdioma);

}
