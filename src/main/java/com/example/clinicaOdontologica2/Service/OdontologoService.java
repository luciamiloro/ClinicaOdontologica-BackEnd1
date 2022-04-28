package com.example.clinicaOdontologica2.Service;

import com.example.clinicaOdontologica2.Model.Odontologo;
import com.example.clinicaOdontologica2.Model.OdontologoDTO;
import com.example.clinicaOdontologica2.Repository.IOdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class OdontologoService implements IOdontologoService{


    @Autowired
    private IOdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void createOdontologo(OdontologoDTO odontologo) {
        Odontologo odontologoGuardado = mapper.convertValue(odontologo,Odontologo.class);
        odontologoRepository.save(odontologoGuardado);
    }

    // Buscar odontologo:
    @Override
    public OdontologoDTO readOdontologo(Long id) {
        OdontologoDTO odontologoDTO = null;
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        if(odontologo.isPresent()){
            odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);
        }
        return odontologoDTO;
    }

    // modificar odontologo:
    @Override
    public void updateOdontologo(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        odontologoRepository.save(odontologo);
    }

    //eliminar odontologo:
    @Override
    public void deleteOdontologo(Long id) {
        odontologoRepository.deleteById(id);
    }

    // buscar todos los odontologos:
    @Override
    public Collection<OdontologoDTO> getAll() {
        List<Odontologo> odontologos = odontologoRepository.findAll();
        Set<OdontologoDTO> odontologosDTO = new HashSet<>();
        for (Odontologo odontologo : odontologos) {
            odontologosDTO.add(mapper.convertValue(odontologo,OdontologoDTO.class));
        }
        return odontologosDTO;
    }

}
