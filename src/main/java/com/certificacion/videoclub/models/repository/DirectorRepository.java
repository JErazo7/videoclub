package com.certificacion.videoclub.models.repository;


import com.certificacion.videoclub.models.entities.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("directorRepository")
public interface DirectorRepository extends JpaRepository<Director, Long> {

}
