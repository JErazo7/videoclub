package com.certificacion.videoclub.models.repository;

import com.certificacion.videoclub.models.entities.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("socioRepository")
public interface SocioRepository extends JpaRepository<Socio, Long> {
    @Query("SELECT u FROM Socio u WHERE u.cedula = ?1")
    Socio findUserByCedula(String cedula);

}
