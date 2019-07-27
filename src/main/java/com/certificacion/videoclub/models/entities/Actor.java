package com.certificacion.videoclub.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="act_id")
    private long id;

    @Column(name = "act_nombre")
    private String nombre;


    @OneToOne
    @JoinColumn(name = "sex_id",referencedColumnName = "sex_id")
    private Sexo sexo;

    @JsonIgnore
    @OneToMany(mappedBy = "actor", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private List<ActorPelicula> ActoresPeliculas;

    public Actor() {
        super();
    }

    public Actor(String nombre, Sexo sexo) {
        super();
        this.nombre = nombre;
        this.sexo = sexo;
    }


    /*public List<ActorPelicula> getActoresPeliculas() {
        return ActoresPeliculas;
    }

    public void setActoresPeliculas(List<ActorPelicula> actoresPeliculas) {
        ActoresPeliculas = actoresPeliculas;
    }*/

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

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
}
