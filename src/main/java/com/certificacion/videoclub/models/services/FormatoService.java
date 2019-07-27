package com.certificacion.videoclub.models.services;

import com.certificacion.videoclub.models.entities.Director;
import com.certificacion.videoclub.models.entities.Formato;

import java.util.List;

public interface FormatoService {

    public List<Formato> getAllFormatos();
    public Formato getFormatoById(long id);
    public void removeFormato(long id);
    public void saveFormato(Formato formato);

}
