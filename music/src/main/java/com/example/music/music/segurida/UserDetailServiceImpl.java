package com.example.music.music.segurida;



import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.music.music.modelo.Usuario;
import com.example.music.music.repositorio.UsuriousRepository;


@Service
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private  UsuriousRepository usuriousRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        Usuario usuario = usuriousRepository
                .findOneByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario con el correo proporcionado no exite" + email ));

        return new UserDetailsImpl(usuario);
    }
}
