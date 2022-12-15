package com.example.music.music.repositorio;

import com.example.music.music.modelo.Cancione;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CancionRepositorio extends JpaRepository<Cancione, Long> {
}
