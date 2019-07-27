package com.certificacion.videoclub.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="formato")
public class Formato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="for_id")
    private long id;

    @Column(name="for_nombre")
    private String nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "formato", cascade = CascadeType.ALL)
    private List<Pelicula> peliculas;

    public Formato() {
        super();
    }

    public Formato(String nombre) {
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
