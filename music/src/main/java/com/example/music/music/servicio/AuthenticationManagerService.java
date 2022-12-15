package com.example.music.music.servicio;


import com.example.music.music.modelo.AuthenticationReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationManagerService {

    @Autowired
    private AuthenticationManager authenticationManager;


    public Authentication authenticate(AuthenticationReq authentication) throws AuthenticationException {
        return new UsernamePasswordAuthenticationToken(authentication.getUsuario(),
                authentication.getClave());
    }


}
