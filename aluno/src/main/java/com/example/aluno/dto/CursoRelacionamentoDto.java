package com.example.aluno.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CursoRelacionamentoDto {
	
	private Integer idCursoRelAluno;
	@NotBlank
	private Integer idCurso;
	@NotBlank
	private Integer idMatricula;
	@NotBlank
	private Integer AnoFormacao;
	@Size(max = 50)
	private String status;
	
	public Integer getIdCursoRelAluno() {
		return idCursoRelAluno;
	}
	public void setIdCursoRelAluno(Integer idCursoRelAluno) {
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
