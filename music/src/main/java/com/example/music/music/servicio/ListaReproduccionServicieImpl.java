package com.example.music.music.servicio;

import com.example.music.music.modelo.Cancione;
import com.example.music.music.modelo.ListaReproduccion;
import com.example.music.music.repositorio.CancionRepositorio;
import com.example.music.music.repositorio.ListaReproduccionRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ListaReproduccionServicieImpl implements ListaReproduccionServicie {

    private final ListaReproduccionRepositorio repositorioLista;
    private final CancionRepositorio cancionRepositorio;

    @Override
    public List<ListaReproduccion> getListasReproduccion() {
        return repositorioLista.findAll();
    }

    @Override
    public ListaReproduccion getListasReproduccionPorNombre(String nombrelista) {
        return repositorioLista.findByNombre(nombrelista);
    }

    @Override
    public boolean borrarListaReproduccion(Long id) {
        try {
            repositorioLista.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public ListaReproduccion guardarListaReproduccion(ListaReproduccion list) {
        return repositorioLista.save(list);
    }
}

