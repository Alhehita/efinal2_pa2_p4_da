package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.MatriculaRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class MatriculaServiceImpl implements MatriculaService {

	@Autowired
	private MatriculaRepository matriculaRepository;
	


	@Override
	@Transactional(value = TxType.REQUIRED)
	public void guardar(Matricula matricula) {
		this.matriculaRepository.insertar(matricula);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Matricula> reporteMatriculas() {
		return this.matriculaRepository.reporte();
	}
	
	public void matricular(Matricula matricula, Integer id) {
		Estudiante estudiante = new Estudiante();
		
		Materia materia = new Materia();
		
		Matricula idEstudiante = this.matriculaRepository.buscarEstudianteId(id);
		
		if(idEstudiante.equals(estudiante.getId())) {
			
		}
	}

}
