package com.certificacion.videoclub.models.services;

import com.certificacion.videoclub.models.entities.Actor;
import com.certificacion.videoclub.models.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("actorService")
public class ActorServiceImp implements ActorService {


    @Qualifier("actorRepository")
    @Autowired
    private ActorRepository actorRepository;


    @Override
    public List<Actor> getAllActores() {
        return actorRepository.findAll();
    }

    @Override
    public Actor getActorById(long id) {
        return actorRepository.getOne(id);
    }

    @Override
    public void removeActor(long id) {
        actorRepository.deleteById(id);
    }

    @Override
    public void saveActor(Actor actor) {
        actorRepository.save(actor);
    }
}