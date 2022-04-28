package com.example.clinicaOdontologica2.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteDTO {
    private Long id;
    private String apellido;
    private String nombre;
    private Integer dni;
    private String email;
    private String fechaIngreso;

    private DomicilioDTO domicilio;
}
