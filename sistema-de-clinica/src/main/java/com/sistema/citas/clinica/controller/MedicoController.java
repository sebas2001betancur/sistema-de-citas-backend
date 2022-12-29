package com.sistema.citas.clinica.controller;

import com.sistema.citas.clinica.entities.Medico;
import com.sistema.citas.clinica.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/medico")
@CrossOrigin(origins = "http://localhost:3000")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;


    //MEDICO
    @PostMapping("/guardarMedico")
    public ResponseEntity<Medico> guardarMedico(@RequestBody Medico medico){
        Medico medicoGuardado = medicoService.agregarMedico(medico);
        return ResponseEntity.ok(medicoGuardado);
    }

    @GetMapping("/listarMedicos")
    public ResponseEntity<?> listarMedicos(){
        return ResponseEntity.ok(medicoService.obtenerMedicos());
    }


    @GetMapping("/listar/{medicoId}")
    public Medico listarMedicoPorId(@PathVariable Long medicoId){
        return medicoService.obtenerMedicoPorId(medicoId);
    }
    @PutMapping("/actualizarMedico/{medicoId}")
    public Medico actualizarMedico(@PathVariable("medicoId") Long idMedico,@RequestBody Medico medico){
        return medicoService.actualizarMedico(idMedico,medico);
    }

    @DeleteMapping("/eliminar/{medicoId}")
    public ResponseEntity<Map<String,Boolean>> eliminarMedico(@PathVariable("medicoId") Long id) {
        boolean deleted = false;
        deleted = medicoService.eliminarMedico(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);
    }
}
