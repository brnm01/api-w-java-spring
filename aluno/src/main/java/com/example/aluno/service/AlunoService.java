package com.example.aluno.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.aluno.model.Aluno;
import com.example.aluno.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	public boolean findByIdMatricula(Integer idMatricula) {
		return alunoRepository.existsByIdMatricula(idMatricula);
	}

    public List<Aluno> findByName(String name) {
        return alunoRepository.findByNome(name);
    }
	
    @Transactional
    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }	
    
    @Transactional
    public void delete(Aluno aluno) {
        alunoRepository.delete(aluno);    
    }

	public Page<Aluno> findAll(Pageable pageable) {
		return alunoRepository.findAll(pageable);
	}

	public Optional<Aluno> findById(Integer idMatricula) {
		return alunoRepository.findById(idMatricula);
	}
    
	
}
