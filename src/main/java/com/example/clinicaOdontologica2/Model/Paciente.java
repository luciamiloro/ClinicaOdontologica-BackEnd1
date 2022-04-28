package com.example.clinicaOdontologica2.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity //notaciones de como mapea con la db
@Table(name="Pacientes" ) //la tabla con la que quiero que matchee
@Getter
@Setter
public class Paciente {
    @Id
    @GeneratedValue// (strategy = GenerationType.SEQUENCE)
    private Long id;
    private String apellido;
    private String nombre;
    private Integer dni;
    private String email;
    private String fechaIngreso;

    @OneToOne(cascade = {CascadeType.ALL})
    private Domicilio domicilio;

    @OneToMany(mappedBy = "paciente")
    @JsonIgnore //sino entra en ciclo infinito
    private Set<Turno> turnos;

    //SI FUNCA PROBAR BORRAR CONSTRUCTORES
    public Paciente(Long id, String apellido, String nombre, int dni, String email, String fechaIngreso) {
        this.id = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
        this.fechaIngreso = fechaIngreso;
    }

    public Paciente(String apellido, String nombre, int dni, String email, String fechaIngreso) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
        this.fechaIngreso = fechaIngreso;
    }

    public Paciente() {
    }
}
