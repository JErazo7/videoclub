package com.certificacion.videoclub.models.services;

import com.certificacion.videoclub.models.entities.Pelicula;
import com.certificacion.videoclub.models.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("peliculaService")
public class PeliculaServiceImp implements PeliculaService {


    @Qualifier("peliculaRepository")
    @Autowired
    private PeliculaRepository repository;


    @Override
    public List<Pelicula> getAllPeliculas() {
        return repository.findAll();
    }

    @Override
    public Pelicula getPeliculaById(long id) {
        return repository.getOne(id);
    }

    @Override
    public void removePelicula(long id) {
        repository.deleteById(id);
    }

    @Override
    public void savePelicula(Pelicula pelicula) {
        repository.save(pelicula);
    }
}