package com.certificacion.videoclub.models.services;

import com.certificacion.videoclub.models.entities.Socio;
import com.certificacion.videoclub.models.repository.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("socioService")
public class SocioServiceImp implements SocioService {


    @Qualifier("socioRepository")
    @Autowired
    private SocioRepository socioRepository;

    @Override
    public List<Socio> getAllSocios() {
        return socioRepository.findAll();
    }

    @Override
    public Socio getSocioById(long id) {
        return socioRepository.findById(id).get();
    }



    @Override
    public void removeSocio(long id) {
        socioRepository.deleteById(id);
    }

    @Override
    public Socio findUserByCedula(String cedula) {
        return socioRepository.findUserByCedula(cedula);
    }

    @Override
    public void saveSocio(Socio socio) {
        socioRepository.save(socio);
    }

}