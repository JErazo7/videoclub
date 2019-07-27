package com.certificacion.videoclub.models.repository;


import com.certificacion.videoclub.models.entities.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("generoRepository")
public interface GeneroRepository extends JpaRepository<Genero, Long> {

}
