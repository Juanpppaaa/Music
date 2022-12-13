package com.example.music.music.modelo;

import javax.persistence.*;

@Entity
@Table

public class Cancione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCanciones;

    private String titulo;
    private String artistas;
    private String album;
    private int anno;

    public long getIdCanciones() {
        return idCanciones;
    }

    public void setIdCanciones(long idCanciones) {
        this.idCanciones = idCanciones;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtistas() {
        return artistas;
    }

    public void setArtistas(String artistas) {
        this.artistas = artistas;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }
}
