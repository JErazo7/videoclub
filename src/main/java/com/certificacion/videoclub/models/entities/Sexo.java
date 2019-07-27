package com.certificacion.videoclub.models.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="sexo")
public class Sexo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sex_id")
    private long id;

    @Column(name="sex_nombre")
    private String nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "sexo",cascade = CascadeType.ALL)
    private List<Actor> actores;

    public Sexo() {
        super();
    }


    public Sexo(String nombre, List<Actor> actores) {
        this.nombre = nombre;
        this.actores = actores;
    }

    public List<Actor> getActores() {
        return actores;
    }

    public void setActores(List<Actor> actores) {
        this.actores = actores;
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
