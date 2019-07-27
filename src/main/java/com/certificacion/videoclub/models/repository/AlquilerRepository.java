package com.certificacion.videoclub.models.repository;

import com.certificacion.videoclub.models.entities.Alquiler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository("alquilerRepository")
public interface AlquilerRepository extends JpaRepository<Alquiler, Long> {
   //Aqui va la consulta
    @Query(value="SELECT sum(alq_valor) FROM Alquiler WHERE alq_fecha_entrega BETWEEN '2019-01-01' AND '2019-12-31'",nativeQuery = true)
    double getsum();
    @Query(value="SELECT alq_valor FROM Alquiler WHERE alq_fecha_entrega BETWEEN '2019-01-01' AND '2019-12-31'",nativeQuery = true)
    double[] getDatosTabla();

}
