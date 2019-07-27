package com.certificacion.videoclub.models.services;

import com.certificacion.videoclub.models.entities.Director;
import com.certificacion.videoclub.models.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("directorService")
public class DirectorServiceImp implements DirectorService {


    @Qualifier("directorRepository")
    @Autowired
    private DirectorRepository repository;


    @Override
    public List<Director> getAllDirectores() {
        return repository.findAll();
    }

    @Override
    public Director getDirectorById(long id) {
        return repository.getOne(id);
    }

    @Override
    public void removeDirector(long id) {
        repository.deleteById(id);
    }

    @Override
    public void saveDirector(Director director) {
        repository.save(director);
    }
}