package com.example.clinicaOdontologica2.Controller;

import com.example.clinicaOdontologica2.Model.OdontologoDTO;
import com.example.clinicaOdontologica2.Service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    IOdontologoService odontologoService;

    @PostMapping
    public ResponseEntity<?> addOdontologo(@RequestBody OdontologoDTO odontologoDTO) {
        odontologoService.createOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public OdontologoDTO getOdontologo(@PathVariable long id) {
        return odontologoService.readOdontologo(id);
    }

    @PutMapping()
    public ResponseEntity<?> updateOdontologo(@RequestBody OdontologoDTO odontologoDTO){
        odontologoService.updateOdontologo(odontologoDTO);
        return  ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOdontologo(@PathVariable long id){
        odontologoService.deleteOdontologo(id);
        return ResponseEntity.status(HttpStatus.OK).body("elimiadou");
    }

    @GetMapping("/list")
    public Collection<OdontologoDTO> listOdontologos(){
        return  odontologoService.getAll();
    }

}
