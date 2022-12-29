package com.sistema.citas.clinica.repositories;

import com.sistema.citas.clinica.entities.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioMedico extends JpaRepository<Medico, Long> {

}
