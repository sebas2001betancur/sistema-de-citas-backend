package com.sistema.citas.clinica.repositories;

import com.sistema.citas.clinica.entities.Citas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioCitas extends JpaRepository<Citas, Long> {

}
