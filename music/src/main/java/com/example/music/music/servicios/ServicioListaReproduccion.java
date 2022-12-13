package com.example.music.music.servicios;

import com.example.music.music.modelo.ListaReproduccion;

import java.util.List;

public interface ServicioListaReproduccion {

    List<ListaReproduccion> getListasReproduccion();

    ListaReproduccion getListasReproduccionPorNombre(String nombrelista);

    ListaReproduccion guardarListaReproduccion( ListaReproduccion list);

    boolean  borrarListaReproduccion(Long id);




}
