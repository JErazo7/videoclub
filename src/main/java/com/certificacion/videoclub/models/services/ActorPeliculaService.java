package com.certificacion.videoclub.models.services;

import com.certificacion.videoclub.models.entities.ActorPelicula;

import java.util.List;

public interface ActorPeliculaService {

    public List<ActorPelicula> getAllActoresPeliculas();
    public ActorPelicula getActorPeliculaById(long id);
    public void removeActorPelicula(long id);
    public void saveActorPelicula(ActorPelicula actorPelicula);

}
