package com.sistema.citas.clinica;


import com.sistema.citas.clinica.entities.Citas;

import com.sistema.citas.clinica.repositories.RepositorioCitas;
import com.sistema.citas.clinica.service.CitaService;
import com.sistema.citas.clinica.service.MedicoService;
import com.sistema.citas.clinica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SistemaDeClinicaApplication implements CommandLineRunner {

	@Autowired
	private MedicoService medicoService;

	@Autowired
	private PacienteService pacienteService;

	@Autowired
	private CitaService citaService;

	@Autowired
	private RepositorioCitas repositorioCitas;



	public static void main(String[] args) {
		SpringApplication.run(SistemaDeClinicaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/**Medico medico = new Medico();
		medico.setNombre("sebastian");
		medico.setIdentificacion("1005911567");
		medico.setTipoIdentificacion("cedula");
		medico.setNumTarjetaPro("22383");
		medico.setAñosExperiencia(4);
		medico.setEspecialidad("neurologia");
		medico.setHoraInicio("08:00");
		medico.setHoraFin("09:00");

		medicoService.agregarMedico(medico);

		Paciente paciente = new Paciente();

		paciente.setNombre("david");
		LocalDate localDate = LocalDate.of(1980, 1, 1);
		Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		//paciente.setFechaNacimiento(date);
		paciente.setIdentificacion("1005965567");
		paciente.setTipoIdentificacion("cedula");
		paciente.setEpsPaciente("Sura");
		paciente.setHistoriaClinica("sufro de hipertension, no tengo ningun antecedente de otra enfermedad, por parte de mis padres soy sano");

		pacienteService.agregarPaciente(paciente);*/

		//Citas citas = new Citas();
		//citaService.agregarCita(2L, 1L);

		/**citas.setNombreMedico(medico.getNombre());
		citas.setNombrePaciente(paciente.getNombre());
		citas.setIdentificacionPaciente(paciente.getIdentificacion());
		citas.setEpsCita(paciente.getEpsPaciente());

		repositorioCitas.save(citas);*/


	}
}
