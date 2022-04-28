package com.example.clinicaOdontologica2.Service;

import com.example.clinicaOdontologica2.Model.Paciente;
import com.example.clinicaOdontologica2.Model.PacienteDTO;
import com.example.clinicaOdontologica2.Repository.IPacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class PacienteService implements IPacienteService{

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired
    ObjectMapper mapper;

    // Agregar paciente:
    public void createPaciente(PacienteDTO paciente) {
        Paciente pacienteGuardado = mapper.convertValue(paciente,Paciente.class);
        pacienteRepository.save(pacienteGuardado);
    }

    // Buscar paciente:
    public PacienteDTO readPaciente(Long id) {
        PacienteDTO pacienteDTO = null;
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        if(paciente.isPresent()){
            pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);
        }
        return pacienteDTO;
    }

    // modificar paciente:
    public void updatePaciente(PacienteDTO pacienteDTO){
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        pacienteRepository.save(paciente);
    }

    // eliminar paciente:
    public void deletePaciente(Long id){

        pacienteRepository.deleteById(id);
    }

    // buscar todos los pacientes:
    public Collection<PacienteDTO> getAll(){
        List<Paciente> pacientes = pacienteRepository.findAll();
        Set<PacienteDTO> pacientesDTO = new HashSet<>();
        for (Paciente paciente : pacientes) {
            pacientesDTO.add(mapper.convertValue(paciente,PacienteDTO.class));
        }
        return pacientesDTO;
    }

    // pacientes con apellido igual
    public Set<PacienteDTO> getPacienteWithLastNameLike(String apellido){
        Set<Paciente> pacientes =  pacienteRepository.getPacienteWithLastNameLike(apellido);

        Set<PacienteDTO> pacientesDTO = new HashSet<>();
        for(Paciente paciente : pacientes){
            PacienteDTO pacienteDTO = new PacienteDTO();

            /*esto hace el mapper: mapper.convertValue(student, StudentDTO.class);*/
            pacienteDTO.setNombre(paciente.getNombre());
            pacienteDTO.setApellido(paciente.getApellido());
            pacienteDTO.setId(paciente.getId());

            pacientesDTO.add(pacienteDTO);
        }
        return pacientesDTO;

    }

}
