package com.certificacion.videoclub.models.services;

import com.certificacion.videoclub.models.entities.Alquiler;
import com.certificacion.videoclub.models.repository.AlquilerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("alquilerService")
public class AlquilerServiceImp implements AlquilerService {

    //Aqui se implementa

    @Qualifier("alquilerRepository")
    @Autowired
    private AlquilerRepository repository;


    @Override
    public List<Alquiler> getAllAlquileres() {
        return repository.findAll();
    }

    @Override
    public Alquiler getAlquilerById(long id) {
        return repository.getOne(id);
    }

    @Override
    public void removeAlquiler(long id) {
        repository.deleteById(id);
    }

    @Override
    public void saveAlquiler(Alquiler alquiler) {
        repository.save(alquiler);
    }

    @Override
    public double getsum(){return repository.getsum();}

    @Override
    public double[] getDatosTabla() {
        return repository.getDatosTabla();
    }
}