package com.certificacion.videoclub.models.repository;


import com.certificacion.videoclub.models.entities.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("peliculaRepository")
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

}
