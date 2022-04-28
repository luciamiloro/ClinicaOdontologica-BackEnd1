package com.example.clinicaOdontologica2.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TurnoDTO {
    private Long id;
    private Date date;
    private Paciente paciente;
    private Odontologo odontologo;
}
