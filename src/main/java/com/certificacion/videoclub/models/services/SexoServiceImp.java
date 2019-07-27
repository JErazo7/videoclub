package com.certificacion.videoclub.models.services;

import com.certificacion.videoclub.models.entities.Sexo;
import com.certificacion.videoclub.models.repository.SexoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sexoService")
public class SexoServiceImp implements SexoService {


    @Qualifier("sexoRepository")
    @Autowired
    private SexoRepository repository;


    @Override
    public List<Sexo> getAllSexos() {
        return repository.findAll();
    }

    @Override
    public Sexo getSexoById(long id) {
        return repository.getOne(id);
    }

    @Override
    public void removeSexo(long id) {
        repository.deleteById(id);
    }

    @Override
    public void saveSexo(Sexo sexo) {
        repository.save(sexo);
    }
}