package com.certificacion.videoclub.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="director")
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="dir_id")
    private long id;

    @Column (name="dir_nombre")
    private String nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "director", cascade = CascadeType.ALL)
    private List<Pelicula> peliculas;

    public Director() {
        super();
    }

    public Director(String nombre) {
        super();
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
