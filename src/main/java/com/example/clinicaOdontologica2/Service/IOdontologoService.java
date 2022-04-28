package com.example.clinicaOdontologica2.Service;

import com.example.clinicaOdontologica2.Model.OdontologoDTO;

import java.util.Collection;


public interface IOdontologoService {

    public void createOdontologo(OdontologoDTO odontologo);

    public OdontologoDTO readOdontologo(Long id);

    public void updateOdontologo(OdontologoDTO odontologoDTO);


    public void deleteOdontologo(Long id);


    public Collection<OdontologoDTO> getAll();


}
