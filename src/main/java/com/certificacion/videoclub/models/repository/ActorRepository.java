package com.certificacion.videoclub.models.repository;

import com.certificacion.videoclub.models.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("actorRepository")
public interface ActorRepository extends JpaRepository<Actor, Long> {

}
