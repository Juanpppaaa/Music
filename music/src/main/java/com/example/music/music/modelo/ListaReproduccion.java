package com.example.music.music.modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class ListaReproduccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // para que se vaya autoincrmentando
    private Long idListaReproduccion;
    @Column
    private String nombre;
    @Column
    private String descripcion;

    @OneToMany(mappedBy = "idCanciones", cascade = {CascadeType.PERSIST})
    private List<Cancione> listCanciones;

    public ListaReproduccion() {
    }


    public List<Cancione> getListCanciones() {
        if (listCanciones.isEmpty()){
            listCanciones = new ArrayList<Cancione>();
        }
        return listCanciones;
    }

    public Long getIdListaReproduccion() {
        return this.idListaReproduccion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setIdListaReproduccion(Long idListaReproduccion) {
        this.idListaReproduccion = idListaReproduccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setListCanciones(List<Cancione> listCanciones) {
        this.listCanciones = listCanciones;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ListaReproduccion)) return false;
        final ListaReproduccion other = (ListaReproduccion) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$idListaReproduccion = this.getIdListaReproduccion();
        final Object other$idListaReproduccion = other.getIdListaReproduccion();
        if (this$idListaReproduccion == null ? other$idListaReproduccion != null : !this$idListaReproduccion.equals(other$idListaReproduccion))
            return false;
        final Object this$nombre = this.getNombre();
        final Object other$nombre = other.getNombre();
        if (this$nombre == null ? other$nombre != null : !this$nombre.equals(other$nombre)) return false;
        final Object this$descripcion = this.getDescripcion();
        final Object other$descripcion = other.getDescripcion();
        if (this$descripcion == null ? other$descripcion != null : !this$descripcion.equals(other$descripcion))
            return false;
        final Object this$listCanciones = this.getListCanciones();
        final Object other$listCanciones = other.getListCanciones();
        if (this$listCanciones == null ? other$listCanciones != null : !this$listCanciones.equals(other$listCanciones))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ListaReproduccion;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $idListaReproduccion = this.getIdListaReproduccion();
        result = result * PRIME + ($idListaReproduccion == null ? 43 : $idListaReproduccion.hashCode());
        final Object $nombre = this.getNombre();
        result = result * PRIME + ($nombre == null ? 43 : $nombre.hashCode());
        final Object $descripcion = this.getDescripcion();
        result = result * PRIME + ($descripcion == null ? 43 : $descripcion.hashCode());
        final Object $listCanciones = this.getListCanciones();
        result = result * PRIME + ($listCanciones == null ? 43 : $listCanciones.hashCode());
        return result;
    }

    public String toString() {
        return "ListaReproduccion(idListaReproduccion=" + this.getIdListaReproduccion() + ", nombre=" + this.getNombre() + ", descripcion=" + this.getDescripcion() + ", listCanciones=" + this.getListCanciones() + ")";
    }
}
