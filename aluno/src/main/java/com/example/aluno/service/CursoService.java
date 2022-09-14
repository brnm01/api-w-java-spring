package com.example.aluno.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.aluno.model.Curso;
import com.example.aluno.repository.CursoRepository;

@Service
public class CursoService {
	
	@Autowired /*injeta dependencia do repository nesse Service*/
	CursoRepository cursoRepository;
	
    @Transactional
    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }	
    
    @Transactional /*Caso der erro durante a transação ele garante o rollback*/
    public void delete(Curso curso) {
    	cursoRepository.delete(curso);    
    }
    
	public boolean findByTituloCurso(String tituloCurso) {
		return cursoRepository.existsByTituloCurso(tituloCurso);
	}
	
	public boolean findByIdCurso(Integer IdCurso) {
		return cursoRepository.existsByIdCurso(IdCurso);
	}

	public Page<Curso> findAll(Pageable pageable) {
		return cursoRepository.findAll(pageable);
	}

	public Optional<Curso> findById(Integer idCurso) {
		return cursoRepository.findById(idCurso);
	}	
}
