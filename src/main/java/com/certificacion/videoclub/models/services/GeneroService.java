package com.certificacion.videoclub.models.services;

import com.certificacion.videoclub.models.entities.Formato;
import com.certificacion.videoclub.models.entities.Genero;

import java.util.List;

public interface GeneroService {

    public List<Genero> getAllGeneros();
    public Genero getGeneroById(long id);
    public void removeGenero(long id);
    public void saveGenero(Genero genero);

}
