package com.example.aluno.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "aluno")
public class Aluno implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idMatricula;
	
	@Column(nullable = false, length = 50)
	private String nome;
	
	@Column(nullable = false, length = 12)
	private String dataNascAluno;
	
	@Column(nullable = false, length = 12)
	private String sexo;

	@Column(nullable = false)
	private LocalDateTime dataCadastro;
    
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

	public String getDataNascAluno() {
		return dataNascAluno;
	}

	public void setDataNascFuncionario(String dataNascAluno) {
		this.dataNascAluno = dataNascAluno;
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
	
}
