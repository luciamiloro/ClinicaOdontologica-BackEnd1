package com.example.clinicaOdontologica2.Controller;

import com.example.clinicaOdontologica2.Model.PacienteDTO;
import com.example.clinicaOdontologica2.Service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    IPacienteService pacienteService;

    @PostMapping
    public ResponseEntity<?> addPaciente(@RequestBody PacienteDTO pacienteDTO) {
        pacienteService.createPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public PacienteDTO getPaciente(@PathVariable long id) {
        return  pacienteService.readPaciente(id);
    }

    @PutMapping()
    public ResponseEntity<?> updatePaciente(@RequestBody PacienteDTO pacienteDTO){
        pacienteService.updatePaciente(pacienteDTO);
        return  ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePaciente(@PathVariable long id){
        pacienteService.deletePaciente(id);
        return ResponseEntity.status(HttpStatus.OK).body("elimiadou");
    }

    @GetMapping("/listPacientes")
    public Collection<PacienteDTO> listPacientes(){
        return  pacienteService.getAll();
    }

    @GetMapping("/listapellido")
    public Set<PacienteDTO> listPacientes(@RequestParam String apellido)
    {
        return pacienteService.getPacienteWithLastNameLike(apellido);
    }

}
