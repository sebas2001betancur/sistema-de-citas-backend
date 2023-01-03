package com.sistema.citas.clinica.service.impl;

import com.sistema.citas.clinica.entities.Medico;
import com.sistema.citas.clinica.exception.ResourceNotFoundException;
import com.sistema.citas.clinica.repositories.RepositorioMedico;
import com.sistema.citas.clinica.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class MedicoServiceImpl implements MedicoService {

    @Autowired
    private RepositorioMedico repositorioMedico;

    @Override
    public Medico agregarMedico(Medico medico) {
        return repositorioMedico.save(medico);
    }

    @Override
    public Medico actualizarMedico(Long id, Medico medico) {
        Medico updateMedico = repositorioMedico.findById(id).get();
               // .orElseThrow(() -> new ResourceNotFoundException("Medico con id: "+ id+" no existe"));
        updateMedico.setNombre(medico.getNombre());
        updateMedico.setIdentificacion(medico.getIdentificacion());
        updateMedico.setTipoIdentificacion(medico.getTipoIdentificacion());
        updateMedico.setNumTarjetaPro(medico.getNumTarjetaPro());
        updateMedico.setAñosExperiencia(medico.getAñosExperiencia());
        updateMedico.setEspecialidad(medico.getEspecialidad());
        updateMedico.setHoraInicio(medico.getHoraInicio());
        updateMedico.setHoraFin(medico.getHoraFin());
        updateMedico.setHospital(medico.getHospital());

        return repositorioMedico.save(updateMedico);
    }

    @Override
    public Medico obtenerMedicoPorId(Long id) {
        return repositorioMedico.findById(id).get();

    }

    @Override
    public Set<Medico> obtenerMedicos() {
        return new LinkedHashSet<>(repositorioMedico.findAll());
    }

    @Override
    public boolean eliminarMedico(Long medicoId) {
        Medico medico = repositorioMedico.findById(medicoId).get();
        repositorioMedico.delete(medico);
        return true;
    }
}
