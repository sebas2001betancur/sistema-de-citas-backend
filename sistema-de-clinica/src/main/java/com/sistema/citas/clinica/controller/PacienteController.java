package com.sistema.citas.clinica.controller;

import com.sistema.citas.clinica.entities.Paciente;
import com.sistema.citas.clinica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/paciente")
@CrossOrigin(origins = "http://localhost:3000")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;


    //PACIENTE
    @PostMapping("/guardarPaciente")
    public ResponseEntity<Paciente> guardarPaciente(@RequestBody Paciente paciente){
        Paciente pacienteGuardado = pacienteService.agregarPaciente(paciente);
        return ResponseEntity.ok(pacienteGuardado);
    }

    @GetMapping("/listarPaciente")
    public ResponseEntity<?> listarPacientes(){
        return ResponseEntity.ok(pacienteService.obtenerPacientes());
    }

    @GetMapping("/listar/{pacienteId}")
    public Paciente getPacientesById(@PathVariable("pacienteId") Long pacientesId){
        return pacienteService.obtenerPacientePorId(pacientesId);
    }

    @PutMapping("/actualizarPaciente/{pacienteId}")
    public Paciente actualizarPaciente(@PathVariable("pacienteId") Long pacienteId, @RequestBody Paciente paciente){
        return pacienteService.actualizarPaciente(pacienteId,paciente);
    }

    @DeleteMapping("/eliminarPaciente/{pacienteId}")
    public ResponseEntity<Map<String,Boolean>> eliminarPaciente(@PathVariable("pacienteId") Long pacienteId){
        boolean deleted = false;
        deleted = pacienteService.eliminarPaciente(pacienteId);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);
    }
}
