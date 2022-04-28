package com.example.clinicaOdontologica2.Repository;

import com.example.clinicaOdontologica2.Model.Odontologo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo, Long> {
    @Query("FROM Odontologo p WHERE p.id = ?1" )
    Optional<Odontologo> damePorIDOdontologo(Integer id);
}
