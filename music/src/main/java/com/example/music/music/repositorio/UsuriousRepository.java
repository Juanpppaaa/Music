package com.example.music.music.repositorio;

import com.example.music.music.modelo.ListaReproduccion;
import com.example.music.music.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuriousRepository extends JpaRepository<Usuario, Integer> {

     Optional<Usuario> findOneByEmail(String email);
}
