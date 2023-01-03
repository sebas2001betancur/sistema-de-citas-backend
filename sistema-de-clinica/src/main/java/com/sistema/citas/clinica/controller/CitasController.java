package com.sistema.citas.clinica.controller;

import com.sistema.citas.clinica.entities.Citas;
import com.sistema.citas.clinica.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/citas")
@CrossOrigin(origins = "http://localhost:3000")
public class CitasController {

    @Autowired
    private CitaService citaService;


    //CITAS

    @PostMapping("/AgregarCita/{idMedico}/{idPaciente}/{inicioCita}/{finCita}")
    public ResponseEntity<Citas> AgregarCitas(@PathVariable("idMedico") Long idMedico, @PathVariable("idPaciente") Long idPaciente, @PathVariable("inicioCita") LocalTime inicioCita, @PathVariable("finCita") LocalTime finCita){
        Citas citasGuardado = citaService.agregarCita(idMedico, idPaciente, inicioCita, finCita);
        return ResponseEntity.ok(citasGuardado);
    }

    @GetMapping("/listarCitas")
    public ResponseEntity<?> listarCita(){
        return ResponseEntity.ok(citaService.obtenerCitas());
    }

    @GetMapping("/obtenerPorId/{citasId}")
    public Citas listarCitaPorId(@PathVariable(name = "citasId") Long idMedico, Long idPaciente){
        return citaService.obtenerCitasPorId(idMedico, idPaciente);
    }

    @PutMapping("/actualizarCitas/{idMedico}/{idPaciente}")
    public Citas actualizarCita(@PathVariable("idMedico") Long idMedico,@PathVariable("idPaciente") Long idPaciente, @RequestBody Citas cita){
        return citaService.actualizarCita(idMedico, idPaciente, cita);
    }

    @DeleteMapping("/eliminarCita/{citaId}")
    public ResponseEntity<Map<String,Boolean>> eliminarCita(@PathVariable("citaId") Long id) {
        boolean deleted = false;
        deleted = citaService.eliminarCita(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);
    }

}
