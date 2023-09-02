package com.example.demo.repository.modelo;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "matricula")
public class Matricula {

	@GeneratedValue(generator = "seq_matricula", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_matricula", sequenceName = "seq_matricula", allocationSize = 1)
	@Column(name = "mtra_id")
	@Id
	private Integer id;

	@OneToOne
	@JoinColumn(name = "mtra_id_estudiante")
	private Estudiante estudiante;

	@OneToMany(mappedBy = "matricula")
	private List<Materia> materia;

	@Column(name = "mtra_fecha_columna")
	private LocalDateTime fechaMatricula;

	@Column(name = "mtra_nombre_hilo")
	private String nombreHilo;

}
