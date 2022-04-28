package com.example.clinicaOdontologica2;


import com.example.clinicaOdontologica2.Model.PacienteDTO;
import com.example.clinicaOdontologica2.Service.IPacienteService;
import com.example.clinicaOdontologica2.Service.PacienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class PacienteServiceTest {

    @Autowired
    IPacienteService pacienteService;
    @Test
    public void testgetPacienteWithLastNameLike(){
        PacienteDTO paciente = new PacienteDTO();
        paciente.setNombre("Gilda");
        paciente.setApellido("pruebaTest");

        PacienteService pacienteService = new PacienteService();
        pacienteService.createPaciente(paciente);

        Set<PacienteDTO> pacientes = pacienteService.getPacienteWithLastNameLike("prueba");
        //si el size de esta colección de pacientes es mayor a 0, está bien
        boolean resultado = pacientes.size() > 0;
        assertTrue(resultado);
    }
}
