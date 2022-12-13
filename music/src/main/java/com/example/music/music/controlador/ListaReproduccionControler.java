package com.example.music.music.controlador;

import com.example.music.music.modelo.ListaReproduccion;
import com.example.music.music.servicios.ServicioListaReproduccion;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/listaReproduccion")
@AllArgsConstructor
public class ListaReproduccionControler {

    private  final ServicioListaReproduccion servicioUsuario;

    @PostMapping
    public ResponseEntity guardarListaReproduccion(@RequestBody ListaReproduccion lista){
        return new ResponseEntity(servicioUsuario.guardarListaReproduccion(lista), HttpStatus.CREATED);
    }

    @GetMapping("/obtenerLista")
    public ResponseEntity obtenerLista(){
        return new ResponseEntity(servicioUsuario.getListasReproduccion(), HttpStatus.CREATED);
    }

    @GetMapping("/{nombreLista}")
    public ResponseEntity obtenerListaByNombre(@PathVariable("nombreLista") String nombreLista){
        ListaReproduccion listaRetorno = servicioUsuario.getListasReproduccionPorNombre(nombreLista);
        if (listaRetorno !=null){
            return new ResponseEntity(listaRetorno, HttpStatus.CREATED);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarListaReproduccion(@PathVariable("id") Long id){
        boolean exit = servicioUsuario.borrarListaReproduccion(id);
        if (exit){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }



}
