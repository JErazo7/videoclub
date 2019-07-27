package com.certificacion.videoclub.models.repository;

import com.certificacion.videoclub.models.entities.ActorPelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("actorPeliculaRepository")
public interface ActorPeliculaRepository extends JpaRepository<ActorPelicula, Long> {

}
