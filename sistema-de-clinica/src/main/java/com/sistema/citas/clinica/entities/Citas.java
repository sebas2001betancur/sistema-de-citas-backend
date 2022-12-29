package com.sistema.citas.clinica.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "citas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Citas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCita;

    private String nombreMedico;

    private String nombrePaciente;

    private String identificacionPaciente;

    private String epsCita;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "idPaciente")
    @JsonIgnore
    private Paciente pacientes;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "idMedico")
    @JsonIgnore
    private Medico medicos;



    /**public void agregarPaciente(Paciente paciente){
        pacienteAgendado.add(paciente);
    }

    public void agregarMedico(Medico medico){
        medicoAgendado.add(medico);
    }*/

}
