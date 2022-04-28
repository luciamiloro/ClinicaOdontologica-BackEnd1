package com.example.clinicaOdontologica2.Repository;

import com.example.clinicaOdontologica2.Model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnoRepository extends JpaRepository<Turno, Long> {
}
