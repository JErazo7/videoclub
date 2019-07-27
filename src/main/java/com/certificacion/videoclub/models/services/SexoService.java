package com.certificacion.videoclub.models.services;

import com.certificacion.videoclub.models.entities.Sexo;

import java.util.List;

public interface SexoService {

    public List<Sexo> getAllSexos();
    public Sexo getSexoById(long id);
    public void removeSexo(long id);
    public void saveSexo(Sexo sexo);

}
