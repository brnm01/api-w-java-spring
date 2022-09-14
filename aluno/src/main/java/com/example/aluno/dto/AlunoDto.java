package com.example.aluno.dto;

import java.time.LocalDateTime;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AlunoDto {

    private Integer idMatricula;

    private LocalDateTime dataCadastro;
    
    @NotBlank
    @Size(max = 50)
    private String nome;
    @NotBlank
    
    @Size(max = 12)
    private String sexo;

    @NotBlank
    private String dataNascAluno;
        
    public Integer getIdMatricula() {
		return idMatricula;
	}
	public void setIdMatricula(Integer idMatricula) {
		this.idMatricula = idMatricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;	
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public String getDataNascAluno() {
		return dataNascAluno;
	}
	public void setDataNascAluno(String dataNascAluno) {
		this.dataNascAluno = dataNascAluno;
	}

}
