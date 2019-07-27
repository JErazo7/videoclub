package com.certificacion.videoclub.models.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="pelicula")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pel_id")
    private long id;

    @Column(name="pel_nombre")
    private String nombre;

    @Column(name = "pel_costo")
    @Digits(integer=10, fraction=2)
    private float costo;

    @Column(name = "pel_fecha_estreno")
    private LocalDate fecha_estreno;

    @ManyToOne
    @JoinColumn(name = "gen_id",referencedColumnName = "gen_id")
    private Genero genero;

    @ManyToOne
    @JoinColumn(name = "dir_id",referencedColumnName = "dir_id")
    private Director director;

    @ManyToOne
    @JoinColumn(name = "for_id",referencedColumnName = "for_id")
    private Formato formato;

    @JsonIgnore
    @OneToMany(mappedBy = "pelicula", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Alquiler> alquileres;

    @JsonIgnore
    @OneToMany(mappedBy = "pelicula", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private List<ActorPelicula> actoresPeliculas;


    public Pelicula() {
        super();
    }

    public Pelicula(String nombre, @Digits(integer = 10, fraction = 2) float costo, LocalDate fecha_estreno) {
        super();
        this.nombre = nombre;
        this.costo = costo;
        this.fecha_estreno = fecha_estreno;
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

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public LocalDate getFecha_estreno() {
        return fecha_estreno;
    }

    public void setFecha_estreno(LocalDate fecha_estreno) {
        this.fecha_estreno = fecha_estreno;
    }

    public List<ActorPelicula> getActoresPeliculas() {
        return actoresPeliculas;
    }

    public void setActoresPeliculas(List<ActorPelicula> actoresPeliculas) {
        this.actoresPeliculas = actoresPeliculas;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    public List<Alquiler> getAlquileres() {
        return alquileres;
    }

    public void setAlquileres(List<Alquiler> alquileres) {
        this.alquileres = alquileres;
    }
}
