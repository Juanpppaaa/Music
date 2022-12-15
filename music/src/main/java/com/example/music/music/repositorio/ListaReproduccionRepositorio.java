package com.example.music.music.repositorio;

import com.example.music.music.modelo.ListaReproduccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ListaReproduccionRepositorio extends JpaRepository<ListaReproduccion, Long> {

@Query(value = "SELECT * FROM LISTA_REPRODUCCION WHERE NOMBRE = ?1", nativeQuery = true)
    ListaReproduccion findByNombre(String nombrelista);

}
