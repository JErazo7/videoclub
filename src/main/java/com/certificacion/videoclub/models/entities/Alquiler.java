package com.certificacion.videoclub.models.entities;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.time.LocalDate;


@Entity
@Table(name="alquiler")
public class Alquiler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="alq_id")
    private long id;

    @Column(name = "alq_fecha_desde")
    private LocalDate fecha_desde;

    @Column(name = "alq_fecha_hasta")
    private LocalDate fecha_hasta;

    @Column(name = "alq_valor")
    @Digits(integer=10, fraction=2)
    private float valor;

    @Column(name = "alq_fecha_entrega")
    private LocalDate fecha_entrega;

    @ManyToOne
    @JoinColumn(name = "soc_id",referencedColumnName = "soc_id")
    private Socio socio;

    @ManyToOne
    @JoinColumn(name = "pel_id",referencedColumnName = "pel_id")
    private Pelicula pelicula;

    public Alquiler() {
        super();
    }

    public Alquiler(LocalDate fecha_desde, LocalDate fecha_hasta, @Digits(integer = 10, fraction = 2) float valor, LocalDate fecha_entrega) {
        super();
        this.fecha_desde = fecha_desde;
        this.fecha_hasta = fecha_hasta;
        this.valor = valor;
        this.fecha_entrega = fecha_entrega;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getFecha_desde() {
        return fecha_desde;
    }

    public void setFecha_desde(LocalDate fecha_desde) {
        this.fecha_desde = fecha_desde;
    }

    public LocalDate getFecha_hasta() {
        return fecha_hasta;
    }

    public void setFecha_hasta(LocalDate fecha_hasta) {
        this.fecha_hasta = fecha_hasta;
    }

    public LocalDate getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(LocalDate fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }


    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }
}
