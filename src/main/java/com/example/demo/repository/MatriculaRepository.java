package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Matricula;

public interface MatriculaRepository {
	
	public void insertar(Matricula matricula);
	
	public List<Matricula> reporte();
	
	public Matricula buscarEstudianteId(Integer id);
	
	public Matricula buscarCodMateria(Integer id);
}
