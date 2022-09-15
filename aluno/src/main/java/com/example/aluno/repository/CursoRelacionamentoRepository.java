package com.example.aluno.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.aluno.model.CursoRelacionamento;

@Repository
public interface CursoRelacionamentoRepository extends JpaRepository<CursoRelacionamento, Integer> {
	
	boolean existsByIdMatriculaAndIdCurso(Integer idMatricula, Integer idCurso);
	List<CursoRelacionamento> findByStatus(String status);
	
}
