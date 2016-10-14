package com.br.todeschini.model.americana;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name="objetos_ambiente")
public class ObjetosAmbiente {
	
	@Id
	@GeneratedValue
	private Long id;

	private String nome;
	
	public ObjetosAmbiente() {
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Categoria categoria;

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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public ObjetosAmbiente(String nome, Categoria categoria) {
		super();
		this.nome = nome;
		this.categoria = categoria;
	}
	
	
	
}
