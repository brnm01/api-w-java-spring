package com.example.aluno.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "curso_relacionamento")
public class CursoRelacionamento implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idCursoRelAluno;
	
	@Column(nullable = false)
	private Integer idCurso;
	
	@Column(nullable = false)
	private Integer idMatricula;
	
	@Column(nullable = true)
	private Integer AnoFormacao;

	@Column(nullable = true, length = 50)
	private String status;
	
	public Integer getIdCursoRelAluno() {
		return idCursoRelAluno;
	}
	public void setIdCursoRelFuncionario(Integer idCursoRelAluno) {
		this.idCursoRelAluno = idCursoRelAluno;
	}

	public Integer getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}

	public Integer getIdMatricula() {
		return idMatricula;
	}

	public void setIdMatricula(Integer idMatricula) {
		this.idMatricula = idMatricula;
	}

	public Integer getAnoFormacao() {
		return AnoFormacao;
	}

	public void setAnoFormacao(Integer anoFormacao) {
		AnoFormacao = anoFormacao;
	}
}
