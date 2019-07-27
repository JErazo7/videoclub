package com.certificacion.videoclub.models.services;

import com.certificacion.videoclub.models.entities.Alquiler;

import java.util.List;

public interface AlquilerService {

    public List<Alquiler> getAllAlquileres();
    public Alquiler getAlquilerById(long id);
    public void removeAlquiler(long id);
    public void saveAlquiler(Alquiler alquiler);
    public double getsum();
    public double[] getDatosTabla();
}
