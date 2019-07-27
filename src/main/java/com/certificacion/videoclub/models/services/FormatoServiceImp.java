package com.certificacion.videoclub.models.services;

import com.certificacion.videoclub.models.entities.Director;
import com.certificacion.videoclub.models.entities.Formato;
import com.certificacion.videoclub.models.repository.DirectorRepository;
import com.certificacion.videoclub.models.repository.FormatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("formatoService")
public class FormatoServiceImp implements FormatoService {


    @Qualifier("formatoRepository")
    @Autowired
    private FormatoRepository repository;


    @Override
    public List<Formato> getAllFormatos() {
        return repository.findAll();
    }

    @Override
    public Formato getFormatoById(long id) {
        return repository.getOne(id);
    }

    @Override
    public void removeFormato(long id) {
        repository.deleteById(id);
    }

    @Override
    public void saveFormato(Formato formato) {
        repository.save(formato);
    }
}