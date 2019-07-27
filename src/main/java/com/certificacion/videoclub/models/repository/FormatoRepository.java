package com.certificacion.videoclub.models.repository;


import com.certificacion.videoclub.models.entities.Formato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("formatoRepository")
public interface FormatoRepository extends JpaRepository<Formato, Long> {

}
