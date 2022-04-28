package com.example.clinicaOdontologica2.Controller;

import com.example.clinicaOdontologica2.Model.TurnoDTO;
import com.example.clinicaOdontologica2.Service.ITurnoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    ITurnoService turnoService;

    //guardar un turno:
    @PostMapping
    public ResponseEntity<?> addTurno(@RequestBody TurnoDTO turnoDTO){
        turnoService.createTurno(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    //listar turnos:
    @GetMapping("/list")
    public Collection<TurnoDTO> listTurnos(){
        return turnoService.getAll();
    }


}
