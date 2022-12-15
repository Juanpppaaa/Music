package com.example.music.music.servicio;

import com.example.music.music.modelo.ListaReproduccion;

import java.util.List;

public interface ListaReproduccionServicie {

    List<ListaReproduccion> getListasReproduccion();

    ListaReproduccion getListasReproduccionPorNombre(String nombrelista);

    ListaReproduccion guardarListaReproduccion( ListaReproduccion list);

    boolean  borrarListaReproduccion(Long id);




}
