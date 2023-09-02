package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Matricula;

public interface MatriculaService {
	
	public void guardar(Matricula matricula);
	
	public List<Matricula> reporteMatriculas();

}
