package com.sistema.citas.clinica.repositories;

import com.sistema.citas.clinica.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioPaciente extends JpaRepository<Paciente, Long> {
}
