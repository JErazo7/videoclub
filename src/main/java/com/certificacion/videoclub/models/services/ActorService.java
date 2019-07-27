package com.certificacion.videoclub.models.services;

import com.certificacion.videoclub.models.entities.Actor;

import java.util.List;

public interface ActorService {

    public List<Actor> getAllActores();
    public Actor getActorById(long id);
    public void removeActor(long id);
    public void saveActor(Actor actor);

}
