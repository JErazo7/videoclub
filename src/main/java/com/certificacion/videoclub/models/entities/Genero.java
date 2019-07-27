package com.certificacion.videoclub.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="genero")
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="gen_id")
    private long id;

    @Column(name="gen_nombre")
    private String nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "genero", cascade = CascadeType.ALL)
    private List<Pelicula> peliculas;

    public Genero() {
        super();
    }

    public Genero(String nombre) {
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

