package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.service.MateriaService;

@Controller
@RequestMapping("/materias")
public class MateriaController {
	
	@Autowired
	private MateriaService materiaService;
	
	@PostMapping("/guardar")
	public String guardarMateria(Materia materia) {
		this.materiaService.guardar(materia);
		return "redirect:/materias/guardar";
	}

	@GetMapping("/guardar")
	public String paginaNuevaMateria(Materia materia) {
		return "vistaNuevaMateria";
	}

}
