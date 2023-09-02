package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Matricula;
import com.example.demo.service.MatriculaService;

@Controller
@RequestMapping("/matriculas")
public class MatriculaController {
	
	@Autowired
	private MatriculaService matriculaService;
	
	
	@PostMapping("/guardar")
	public String guardarMatricula(Matricula matricula) {
		this.matriculaService.guardar(matricula);
		return "redirect:/matriculas/guardar";
	}

	@GetMapping("/guardar")
	public String paginaNuevaMatricula(Matricula matricula) {
		return "vistaNuevaMatricula";
	}

	@GetMapping("/buscar")
	public String buscarMatriculas(Model modelo) {
		List<Matricula> listaMatriculas = this.matriculaService.reporteMatriculas();
		modelo.addAttribute("matriculas",listaMatriculas);
		return "vistaListaMatriculas";
	}

}
