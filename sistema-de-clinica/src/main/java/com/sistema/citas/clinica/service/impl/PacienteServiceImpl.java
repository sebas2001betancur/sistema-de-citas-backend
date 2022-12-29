package com.sistema.citas.clinica.service.impl;

import com.sistema.citas.clinica.entities.Citas;
import com.sistema.citas.clinica.entities.Medico;
import com.sistema.citas.clinica.entities.Paciente;
import com.sistema.citas.clinica.exception.ResourceNotFoundException;
import com.sistema.citas.clinica.repositories.RepositorioCitas;
import com.sistema.citas.clinica.repositories.RepositorioMedico;
import com.sistema.citas.clinica.repositories.RepositorioPaciente;
import com.sistema.citas.clinica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private RepositorioPaciente repositorioPaciente;
    @Autowired
    private RepositorioCitas repositorioCitas;


    @Override
    public Paciente agregarPaciente(Paciente paciente) {
        return repositorioPaciente.save(paciente);
    }

    @Override
    public Paciente actualizarPaciente(Long id, Paciente paciente) {
        Paciente updatePaciente = repositorioPaciente.findById(id).get();
               // .orElseThrow(() -> new ResourceNotFoundException("Paciente con id: "+ id+" no existe"));
        updatePaciente.setNombre(paciente.getNombre());
        updatePaciente.setFechaNacimiento(paciente.getFechaNacimiento());
        updatePaciente.setIdentificacion(paciente.getIdentificacion());
        updatePaciente.setTipoIdentificacion(paciente.getTipoIdentificacion());
        updatePaciente.setEpsPaciente(paciente.getEpsPaciente());
        updatePaciente.setHistoriaClinica(paciente.getHistoriaClinica());

        return repositorioPaciente.save(updatePaciente);
    }

    @Override
    public Paciente obtenerPacientePorId(Long id) {
        return repositorioPaciente.findById(id).get();
    }

    @Override
    public Set<Paciente> obtenerPacientes() {
        return new LinkedHashSet<>(repositorioPaciente.findAll());
    }

    @Override
    public boolean eliminarPaciente(Long pacienteId) {
        Paciente paciente = repositorioPaciente.findById(pacienteId).get();
        repositorioPaciente.delete(paciente);
        return true;
    }





}
