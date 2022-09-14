package com.example.aluno.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600) //permitir que seja acessado de qualquer fonte
@RequestMapping("/aluno/cadastra-curso")   //definicao URI
public class CadastroCursoController {

}
