package com.sistema.citas.clinica.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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

    private String hospital;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPaciente")
    private Paciente paciente;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "medicos", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Citas> citasAgendadas = new ArrayList<>();



}
