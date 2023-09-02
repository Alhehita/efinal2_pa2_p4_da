package com.example.demo.repository;

import java.util.List;

import org.apache.logging.log4j.util.PerformanceSensitive;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Matricula;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Transactional
@Repository
public class MatriculaRepositoryImpl implements MatriculaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Matricula matricula) {
		this.entityManager.persist(matricula);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Matricula> reporte() {
		TypedQuery<Matricula> query = this.entityManager.createQuery(
				"SELECT NEW  com.example.demo.repository.modelo.dto.MatriculaDTO(m.nombre, e.cedula, m.cedula, ma.nombreHilo) FROM Materia m, Estudiante e, Matricula ma",
				Matricula.class);

		return query.getResultList();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Matricula buscarEstudianteId(Integer id) {
		TypedQuery<Matricula> query = this.entityManager.createQuery("SELECT e.cedula FROM Matricula m JOIN m.estudiante e", Matricula.class);
		return query.getSingleResult();
	}
	    

	@Override
	public Matricula buscarCodMateria(Integer id) {
		TypedQuery<Matricula> query = this.entityManager.createQuery("SELECT ma.codigo FROM Matricula m JOIN m.materia ma", Matricula.class);
		return query.getSingleResult();
	}

}
