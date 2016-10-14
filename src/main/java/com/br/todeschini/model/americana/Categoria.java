package com.br.todeschini.model.americana;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="categoria")
public class Categoria {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	
	public Categoria() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria(String nome) {
		super();
		this.nome = nome;
	}
	
	
	

}
