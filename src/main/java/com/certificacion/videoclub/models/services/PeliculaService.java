package com.certificacion.videoclub.models.services;

import com.certificacion.videoclub.models.entities.Pelicula;

import java.util.List;

public interface PeliculaService {

    public List<Pelicula> getAllPeliculas();
    public Pelicula getPeliculaById(long id);
    public void removePelicula(long id);
    public void savePelicula(Pelicula pelicula);

}
