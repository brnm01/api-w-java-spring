package com.example.aluno.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.aluno.model.CursoRelacionamento;
import com.example.aluno.repository.CursoRelacionamentoRepository;

@Service
public class CursoRelacionamentoService {
	
	@Autowired
	CursoRelacionamentoRepository cursoRelacionamentoRepository;
	
    @Transactional
    public CursoRelacionamento save(CursoRelacionamento cursoRelAluno) {
        return cursoRelacionamentoRepository.save(cursoRelAluno);
    }	
    
    @Transactional
    public void delete(CursoRelacionamento cursoRelAluno) {
    	cursoRelacionamentoRepository.delete(cursoRelAluno);    
    }
    
    public boolean findByIdMatriculaAndIdCurso(Integer idCurso, Integer idMatricula) {
		return cursoRelacionamentoRepository.existsByIdMatriculaAndIdCurso(idMatricula, idCurso);
	}

	public Page<CursoRelacionamento> findAll(Pageable pageable) {
		return cursoRelacionamentoRepository.findAll(pageable);
	}

	public Optional<CursoRelacionamento> findById(Integer idCursoRel) {
		return cursoRelacionamentoRepository.findById(idCursoRel);
	}
	
}
