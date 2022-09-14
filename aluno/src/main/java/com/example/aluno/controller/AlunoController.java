package com.example.aluno.controller;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aluno.dto.AlunoDto;
import com.example.aluno.model.Aluno;
import com.example.aluno.service.AlunoService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/aluno")
public class AlunoController {

	@Autowired
	AlunoService alunoService;
	
    @PostMapping
    public ResponseEntity<Object> salvaAluno(@RequestBody @Valid AlunoDto alunoDto) throws ParseException{
        if(alunoService.findByIdMatricula(alunoDto.getIdMatricula())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Aluno já existente!");
        }

        var aluno = new Aluno();
        BeanUtils.copyProperties(alunoDto, aluno);
        aluno.setDataCadastro(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.save(aluno));
    }

    @GetMapping
    public ResponseEntity<Page<Aluno>> getAlunos(@PageableDefault(page = 0, size = 10, sort = "idMatricula", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.findAll(pageable));
    }

    @GetMapping("/{idMatricula}")
    public ResponseEntity<Object> getAluno(@PathVariable(value = "idMatricula") Integer idMatricula){
        Optional<Aluno> aluno = alunoService.findById(idMatricula);
        if (!aluno.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(aluno.get());
    }

    @DeleteMapping("/{idMatricula}")
    public ResponseEntity<Object> deletaAluno(@PathVariable(value = "idMatricula") Integer idMatricula){
        Optional<Aluno> aluno = alunoService.findById(idMatricula);
        if (!aluno.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado.");
        }
        alunoService.delete(aluno.get());
        return ResponseEntity.status(HttpStatus.OK).body("Aluno deletado!");
    }

    @PutMapping("/{idMatricula}")
    public ResponseEntity<Object> updateAluno(@PathVariable(value = "idMatricula") Integer idMatricula,
                                                    @RequestBody @Valid AlunoDto alunoDto){

    	Optional<Aluno> alunoOptional = alunoService.findById(idMatricula);
        if (!alunoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado.");
        }
        var aluno = new Aluno();
        BeanUtils.copyProperties(alunoDto, aluno);
        //Valores que não podem ser alterados
        aluno.setIdMatricula(alunoOptional.get().getIdMatricula());
        aluno.setDataCadastro(alunoOptional.get().getDataCadastro());
        
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.save(aluno));
    }
}
