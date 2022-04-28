package com.example.clinicaOdontologica2.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Turnos")
@Setter
@Getter
public class Turno {
    @Id
    @GeneratedValue
    private Long id;

    private Date date;

    @ManyToOne
    @JoinColumn(name="paciente_id", nullable = false) //son las foraneas de la tabla
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name="odontologo_id", nullable = false)
    private Odontologo odontologo;


}
