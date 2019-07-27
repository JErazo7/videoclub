package com.certificacion.videoclub.models.services;

import com.certificacion.videoclub.models.entities.ActorPelicula;
import com.certificacion.videoclub.models.repository.ActorPeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("actorPeliculaService")
public class ActorPeliculaServiceImp implements ActorPeliculaService {


    @Qualifier("actorPeliculaRepository")
    @Autowired
    private ActorPeliculaRepository repository;


    @Override
    public List<ActorPelicula> getAllActoresPeliculas() {
        return repository.findAll();
    }

    @Override
    public ActorPelicula getActorPeliculaById(long id) {
        return repository.getOne(id);
    }

    @Override
    public void removeActorPelicula(long id) {
        repository.deleteById(id);
    }

    @Override
    public void saveActorPelicula(ActorPelicula actorPelicula) {
        repository.save(actorPelicula);
    }
}