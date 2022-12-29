package com.sistema.citas.clinica.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.*;


@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Medicos")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedico;
    private String nombre;

    private String identificacion;

    private String tipoIdentificacion;

    private String numTarjetaPro;

    private int añosExperiencia;

    private String especialidad;

    private String horaInicio;

    private String horaFin;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPaciente")
    private Paciente paciente;

    @OneToMany(mappedBy = "medicos", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Citas> citasAgendadas = new HashSet<>();



}
