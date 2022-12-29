package com.sistema.citas.clinica.service;

import com.sistema.citas.clinica.entities.Citas;

import java.util.Set;

public interface CitaService {

    Citas agregarCita(Long idMedico, Long idPaciente);

    Citas actualizarCita(Long idMedico, Long idPaciente, Citas cita);

    Citas obtenerCitasPorId(Long idMedico, Long idPaciente);

    Set<Citas> obtenerCitas();

    boolean eliminarCita(Long citaId);
}
