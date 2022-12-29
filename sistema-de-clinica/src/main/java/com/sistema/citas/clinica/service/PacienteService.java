package com.sistema.citas.clinica.service;

import com.sistema.citas.clinica.entities.Citas;
import com.sistema.citas.clinica.entities.Medico;
import com.sistema.citas.clinica.entities.Paciente;

import java.util.Set;

public interface PacienteService {

    Paciente agregarPaciente(Paciente paciente);

    Paciente actualizarPaciente(Long id, Paciente paciente);

    Paciente obtenerPacientePorId(Long id);

    Set<Paciente> obtenerPacientes();

    boolean eliminarPaciente(Long pacienteId);

}
