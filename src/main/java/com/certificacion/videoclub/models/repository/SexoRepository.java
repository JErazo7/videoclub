package com.certificacion.videoclub.models.repository;


import com.certificacion.videoclub.models.entities.Sexo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("sexoRepository")
public interface SexoRepository extends JpaRepository<Sexo, Long> {

}
