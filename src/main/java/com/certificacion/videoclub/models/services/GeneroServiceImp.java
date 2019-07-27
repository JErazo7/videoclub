package com.certificacion.videoclub.models.services;

import com.certificacion.videoclub.models.entities.Formato;
import com.certificacion.videoclub.models.entities.Genero;
import com.certificacion.videoclub.models.repository.FormatoRepository;
import com.certificacion.videoclub.models.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("generoService")
public class GeneroServiceImp implements GeneroService {


    @Qualifier("generoRepository")
    @Autowired
    private GeneroRepository repository;


    @Override
    public List<Genero> getAllGeneros() {
        return repository.findAll();
    }

    @Override
    public Genero getGeneroById(long id) {
        return repository.getOne(id);
    }

    @Override
    public void removeGenero(long id) {
        repository.deleteById(id);
    }

    @Override
    public void saveGenero(Genero genero) {
        repository.save(genero);
    }
}