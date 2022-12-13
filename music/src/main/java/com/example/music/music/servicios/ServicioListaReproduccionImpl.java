package com.example.music.music.servicios;

import com.example.music.music.modelo.ListaReproduccion;
import com.example.music.music.repositorio.ListaReproduccionRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioListaReproduccionImpl implements ServicioListaReproduccion {

    private final ListaReproduccionRepositorio repositorioLista;

    public ServicioListaReproduccionImpl(ListaReproduccionRepositorio repositorioLista) {
        this.repositorioLista = repositorioLista;
    }

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

