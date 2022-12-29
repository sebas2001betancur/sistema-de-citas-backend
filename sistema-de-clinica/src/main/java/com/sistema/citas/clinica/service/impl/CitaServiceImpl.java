package com.sistema.citas.clinica.service.impl;

import com.sistema.citas.clinica.entities.Citas;
import com.sistema.citas.clinica.entities.Medico;
import com.sistema.citas.clinica.entities.Paciente;
import com.sistema.citas.clinica.repositories.RepositorioCitas;
import com.sistema.citas.clinica.service.CitaService;
import com.sistema.citas.clinica.service.MedicoService;
import com.sistema.citas.clinica.service.PacienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;

import java.time.LocalTime;
import java.util.LinkedHashSet;

import java.util.Set;

@Service
public class CitaServiceImpl implements CitaService {

    public static final int ESPACIO_ENTRE_CITAS = 60;  // 1 hora en minutos

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private RepositorioCitas repositorioCitas;

    @Autowired
    private PacienteService pacienteService;




    @Override
    public Citas agregarCita(Long idMedico, Long idPaciente) {
        Citas citas = new Citas();
        Paciente paciente = pacienteService.obtenerPacientePorId(idPaciente);
        Medico medico = medicoService.obtenerMedicoPorId(idMedico);
        String horaInicio = medico.getHoraInicio();
        String horaFin = medico.getHoraFin();
        LocalTime inicio = LocalTime.parse(horaInicio);
        LocalTime fin = LocalTime.parse(horaFin);

        Duration duracionCita = Duration.between(inicio, fin);

        if (duracionCita.toMinutes() > ESPACIO_ENTRE_CITAS) {
            throw new IllegalArgumentException("La cita no es válida porque dura más de 1 hora");
        } else {
            citas.setNombreMedico(medico.getNombre());
            citas.setNombrePaciente(paciente.getNombre());
            citas.setIdentificacionPaciente(paciente.getIdentificacion());
            citas.setEpsCita(paciente.getEpsPaciente());
            return repositorioCitas.save(citas);
        }
    }

    @Override
    public Citas obtenerCitasPorId(Long idMedico, Long idPaciente) {
        Paciente paciente = pacienteService.obtenerPacientePorId(idPaciente);
        Medico medico = medicoService.obtenerMedicoPorId(idMedico);
        Citas citas = new Citas();
        Long idCitas = citas.getIdCita();
        return repositorioCitas.findById(idCitas).get();
    }

        @Override
        public Citas actualizarCita (Long idMedico, Long idPaciente, Citas citas){
            Long idCitas = citas.getIdCita();
            Paciente paciente = pacienteService.obtenerPacientePorId(idPaciente);
            Medico medico = medicoService.obtenerMedicoPorId(idMedico);
            Citas updateCitas = repositorioCitas.findById(idCitas).get();
            // .orElseThrow(() -> new ResourceNotFoundException("cita con id: "+ id+" no existe"));
            updateCitas.setNombreMedico(citas.getNombreMedico());
            updateCitas.setNombrePaciente(citas.getNombrePaciente());
            updateCitas.setIdentificacionPaciente(citas.getIdentificacionPaciente());
            updateCitas.setEpsCita(citas.getEpsCita());

            return repositorioCitas.save(updateCitas);
        }

    @Override
    public Set<Citas> obtenerCitas() {
        return new LinkedHashSet<>(repositorioCitas.findAll());
    }

    @Override
    public boolean eliminarCita(Long citaId) {
        Citas citas = repositorioCitas.findById(citaId).get();
        repositorioCitas.delete(citas);
        return true;
    }

}
