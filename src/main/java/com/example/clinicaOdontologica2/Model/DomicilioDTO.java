package com.example.clinicaOdontologica2.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DomicilioDTO {
    private Long id;
    private String calle;
    private Integer numero;
    private String localidad;
    private String provincia;
}
