package com.example.aluno.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.aluno.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
	boolean existsByIdMatricula(Integer idMatricula);
	List<Aluno> findByNome(String name);
}
