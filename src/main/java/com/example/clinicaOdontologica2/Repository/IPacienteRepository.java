package com.example.clinicaOdontologica2.Repository;

import com.example.clinicaOdontologica2.Model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Long> {

    //HQL:

    @Query("FROM Paciente p WHERE p.apellido like %:apellido%") //query haciendolo teniendo en cuenta el nomrbe de las entidades clase, no las tablass
    Set<Paciente> getPacienteWithLastNameLike(@Param("apellido")String apellido);
}
