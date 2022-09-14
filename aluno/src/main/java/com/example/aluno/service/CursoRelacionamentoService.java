package com.example.aluno.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
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
}
