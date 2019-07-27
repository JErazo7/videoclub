package com.certificacion.videoclub.models.services;

import com.certificacion.videoclub.models.entities.Socio;

import java.util.List;

public interface SocioService {

    public List<Socio> getAllSocios();
    public Socio getSocioById(long id);
    public void removeSocio(long id);
    public Socio findUserByCedula(String cedula);
    public void saveSocio(Socio socio);

}
