package com.example.aluno.controller;

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

import com.example.aluno.dto.CursoDto;
import com.example.aluno.model.Curso;
import com.example.aluno.service.CursoService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/curso")
public class CursoController {
	@Autowired
	CursoService cursoService;
	
    @PostMapping
    public ResponseEntity<Object> salvaCurso(@RequestBody @Valid CursoDto cursoDto){
        if(cursoService.findByIdCurso(cursoDto.getIdCurso())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Curso já existente!");
        }
        var curso = new Curso();
        BeanUtils.copyProperties(cursoDto, curso);
        curso.setDataCadastro(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.save(curso));
    }

    @GetMapping
    public ResponseEntity<Page<Curso>> getCursos(@PageableDefault(page = 0, size = 10, sort = "idCurso", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.findAll(pageable));
    }

    @GetMapping("/{idCurso}")
    public ResponseEntity<Object> getCurso(@PathVariable(value = "idCurso") Integer idCurso){
        Optional<Curso> curso = cursoService.findById(idCurso);
        if (!curso.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(curso.get());
    }

    @DeleteMapping("/{idCurso}")
    public ResponseEntity<Object> deletaCurso(@PathVariable(value = "idCurso") Integer idCurso){
        Optional<Curso> curso = cursoService.findById(idCurso);
        if (!curso.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso não encontrado.");
        }
        cursoService.delete(curso.get());
        return ResponseEntity.status(HttpStatus.OK).body("Curso deletado!");
    }

    @PutMapping("/{idCurso}")
    public ResponseEntity<Object> atualizaCurso(@PathVariable(value = "idCurso") Integer idCurso,
                                                    @RequestBody @Valid CursoDto cursoDto){

    	Optional<Curso> cursoOptional = cursoService.findById(idCurso);
        if (!cursoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso não encontrado.");
        }
        var curso = new Curso();
        BeanUtils.copyProperties(cursoDto, curso);
        //Valores que não podem ser alterados
        curso.setIdCurso(cursoOptional.get().getIdCurso());
        curso.setDataCadastro(cursoOptional.get().getDataCadastro());
        
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.save(curso));
    }
}
