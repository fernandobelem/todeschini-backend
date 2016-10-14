package com.br.todeschini.model.americana;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="categoria")
public class Categoria {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	
	@OneToMany(mappedBy = "categoria")
	private Set<ObjetosAmbiente> objetosAmbiente;
	
	public Categoria() {
	}

	public Set<ObjetosAmbiente> getObjetosAmbiente() {
		if(objetosAmbiente == null){
			objetosAmbiente = new HashSet<ObjetosAmbiente>();
		}
		return objetosAmbiente;
	}


	public void setObjetosAmbiente(Set<ObjetosAmbiente> objetosAmbiente) {
		this.objetosAmbiente = objetosAmbiente;
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
