package com.example.clinicaOdontologica2.Service;

import com.example.clinicaOdontologica2.Model.Turno;
import com.example.clinicaOdontologica2.Model.TurnoDTO;
import com.example.clinicaOdontologica2.Repository.ITurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TurnoService implements ITurnoService{

    @Autowired
    ITurnoRepository turnoRepository;

    @Autowired
    ObjectMapper mapper;

    public void createTurno(TurnoDTO turnoDTO){
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        turnoRepository.save(turno);
    }

    public Collection<TurnoDTO> getAll(){
        List<Turno> turnos = turnoRepository.findAll();

        Set<TurnoDTO> turnoDTO = new HashSet<>();
        for (Turno turno: turnos) {
            turnoDTO.add(mapper.convertValue(turno, TurnoDTO.class));
        }
        return turnoDTO;
    }
}
