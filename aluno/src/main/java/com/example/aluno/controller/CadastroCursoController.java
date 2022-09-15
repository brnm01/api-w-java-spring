package com.example.aluno.controller;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aluno.dto.CursoRelacionamentoDto;
import com.example.aluno.model.CursoRelacionamento;
import com.example.aluno.service.CursoRelacionamentoService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600) //permitir que seja acessado de qualquer fonte
@RequestMapping("/aluno/cadastra-aluno-curso")   //definicao URI
public class CadastroCursoController {
	
	@Autowired
	CursoRelacionamentoService cursoRelService;
	
    @PostMapping
    public ResponseEntity<Object> salvaCursoAlunoRel(@RequestBody @Valid CursoRelacionamentoDto cursoRelAlunoDto){
        if(cursoRelService.findByIdMatriculaAndIdCurso(cursoRelAlunoDto.getIdCurso(), cursoRelAlunoDto.getIdMatricula())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Curso já existente!");
        }
        if (cursoRelAlunoDto.getStatus().equals(null))
        	cursoRelAlunoDto.setStatus("CADASTRADO");
        
        var cursoRelacionamento = new CursoRelacionamento();
        BeanUtils.copyProperties(cursoRelAlunoDto, cursoRelacionamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoRelService.save(cursoRelacionamento));
    }
    
    @GetMapping
    public ResponseEntity<Page<CursoRelacionamento>> getCursos(@PageableDefault(page = 0, size = 10, sort = "idCursoRelAluno", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(cursoRelService.findAll(pageable));
    }
    
    

}
