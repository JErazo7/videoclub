package com.certificacion.videoclub.models.services;

import com.certificacion.videoclub.models.entities.Director;

import java.util.List;

public interface DirectorService {

    public List<Director> getAllDirectores();
    public Director getDirectorById(long id);
    public void removeDirector(long id);
    public void saveDirector(Director director);

}
