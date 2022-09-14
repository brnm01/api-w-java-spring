package com.example.aluno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.aluno.model.Curso;

/* JpaRepository possui metodos prontos para utilizar para o banco de dados. Ex: buscar um recurso, salvar, deletar etc
 * Parametros: Model = Curso
 * 			   Identificador = Integer*/

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
	boolean existsByTituloCurso(String tituloCurso);
	boolean existsByIdCurso(Integer IdCurso);
}
