package com.certificacion.videoclub.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="socio")
public class Socio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="soc_id")
    private long id;

    @Column(name="soc_cedula")
    private String cedula;

    @Column(name="soc_nombre")
    private String nombre;

    @Column(name="soc_direccion")
    private String direccion;

    @Column(name="soc_telefono")
    private String telefono;

    @Column(name="soc_correo")
    private String correo;

    @JsonIgnore
    @OneToMany(mappedBy = "socio", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Alquiler> alquileres;

    public Socio() {
        super();
    }

    public Socio(String cedula, String nombre, String direccion, String telefono, String correo) {
        super();
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    public List<Alquiler> getAlquileres() {
        return alquileres;
    }

    public void setAlquileres(List<Alquiler> alquileres) {
        this.alquileres = alquileres;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
