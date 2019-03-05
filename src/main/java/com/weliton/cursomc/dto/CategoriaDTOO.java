package com.weliton.cursomc.dto;

import java.io.Serializable;

public class CategoriaDTOO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	
	
	public CategoriaDTOO(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public CategoriaDTOO() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}