package com.example.clinicaOdontologica2.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Domicilios")
@Getter
@Setter
public class Domicilio {
    @Id
    @GeneratedValue
    private Long id;
    private String calle;
    private Integer numero;
    private String localidad;
    private String provincia;


}
