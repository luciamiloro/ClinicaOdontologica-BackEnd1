package com.example.clinicaOdontologica2.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="Odontologos")
@Getter
@Setter
public class Odontologo {

    @Id
    //@SequenceGenerator(name = "odontologo_sequence", sequenceName = "odontologo_sequence")
    @GeneratedValue //(strategy = GenerationType.SEQUENCE, generator = "sequence_generator")
    private Long id;
    private String apellido;
    private String nombre;
    private Integer matricula;

    @OneToMany(mappedBy = "odontologo")
    @JsonIgnore
    private Set<Turno> turnos;

    //si funca probar borrar constructor vacio
    public Odontologo() {

    }

//    public Odontologo(String apellido, String nombre, Integer matricula) {
//        this.apellido = apellido;
//        this.nombre = nombre;
//        this.matricula = matricula;
//    }


}
