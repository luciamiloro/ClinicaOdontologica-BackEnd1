package com.example.clinicaOdontologica2.Service;

import com.example.clinicaOdontologica2.Model.PacienteDTO;

import java.util.*;

public interface IPacienteService {

    public void createPaciente(PacienteDTO paciente);

    public PacienteDTO readPaciente(Long id);

    public void updatePaciente(PacienteDTO pacienteDTO);


    public void deletePaciente(Long id);


    public Collection<PacienteDTO> getAll();


    public Set<PacienteDTO> getPacienteWithLastNameLike(String apellido);

}
