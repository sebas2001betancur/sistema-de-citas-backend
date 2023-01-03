package com.sistema.citas.clinica.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.sql.Date;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Pacientes")
@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaciente;
    private String nombre;

    private Date fechaNacimiento;

    private String identificacion;

    private String tipoIdentificacion;

    private String epsPaciente;

    @Column(length = 1000000000)
    private String historiaClinica;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idMedico")
    private Medico medico;

    @OneToMany(mappedBy = "pacientes", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Citas> citasAgendadas = new ArrayList<>();


}
