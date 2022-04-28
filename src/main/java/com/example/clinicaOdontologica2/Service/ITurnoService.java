package com.example.clinicaOdontologica2.Service;

import com.example.clinicaOdontologica2.Model.TurnoDTO;

import java.util.Collection;


public interface ITurnoService {
    public void createTurno(TurnoDTO turno);
    public Collection<TurnoDTO> getAll();

}
