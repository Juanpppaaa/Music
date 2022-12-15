package com.example.music.music.controlador;

import com.example.music.music.servicio.AuthenticationManagerService;
import com.example.music.music.servicio.ListaReproduccionServicie;
import com.example.music.music.servicio.ListaReproduccionServicieImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.music.music.modelo.AuthenticationReq;
import com.example.music.music.modelo.ListaReproduccion;
import com.example.music.music.modelo.TokenInfo;
import com.example.music.music.servicio.JwtUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/listaReproduccion")
public class ListaReproduccionControler {

    @Autowired
    private ListaReproduccionServicie servicioUsuario;

    @Autowired
    UserDetailsService usuarioDetailsService;


    @Autowired
    private JwtUtilService jwtUtilService;

    @Autowired
    private AuthenticationManagerService authenticationManagerService;

    private static final Logger logger = LoggerFactory.getLogger(ListaReproduccionControler.class);

    @PostMapping("/guardarLista")
    public ResponseEntity guardarListaReproduccion(@RequestBody ListaReproduccion lista){
        ListaReproduccion listaNueva = servicioUsuario.guardarListaReproduccion(lista);
        if(listaNueva != null){
            return new ResponseEntity(listaNueva, HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

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


    @PostMapping("/publico/authenticate")
    public ResponseEntity<TokenInfo> authenticate(@RequestBody AuthenticationReq authenticationReq) {
        logger.info("Autenticando al usuario {}", authenticationReq.getUsuario());

        authenticationManagerService.authenticate(authenticationReq);

        final UserDetails userDetails = usuarioDetailsService.loadUserByUsername(
                authenticationReq.getUsuario());

        final String jwt = jwtUtilService.generateToken(userDetails);

        TokenInfo tokenInfo = new TokenInfo(jwt);

        return ResponseEntity.ok(tokenInfo);
    }



}
