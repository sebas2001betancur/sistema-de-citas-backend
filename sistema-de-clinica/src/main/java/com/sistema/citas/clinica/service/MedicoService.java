package com.sistema.citas.clinica.service;

import com.sistema.citas.clinica.entities.Medico;

import java.util.Set;

public interface MedicoService {

    Medico agregarMedico(Medico medico);

    Medico actualizarMedico(Long id,Medico medico);

    Medico obtenerMedicoPorId(Long id);

    Set<Medico> obtenerMedicos();

    boolean eliminarMedico(Long medicoId);
}
