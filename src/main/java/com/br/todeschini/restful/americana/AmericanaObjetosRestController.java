package com.br.todeschini.restful.americana;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.todeschini.model.americana.Categoria;
import com.br.todeschini.model.americana.ObjetosAmbiente;
import com.br.todeschini.repository.americana.CategoriaRepository;
import com.br.todeschini.repository.americana.ObjetoRepository;

@RestController
public class AmericanaObjetosRestController {
	
	@Autowired
	ObjetoRepository objRep;
	
	@Autowired
	CategoriaRepository catRep;
	
	@RequestMapping("/selectObjetos")
	public List<ObjetosAmbiente> selectObjetos(
			@RequestParam(value = "idCategoria", defaultValue="1") Long idCategoria){
		return objRep.findByCategoria(catRep.findOne(idCategoria));
	}
	
	@RequestMapping("/selectTodosObjetos")
	public Iterable<ObjetosAmbiente> selectTodosObjetos(){
		
		return objRep.findAll();
	}
	
	@RequestMapping("/selectCategorias")
	public Iterable<Categoria> selectCategorias(){
		
		return catRep.findAll();
	}
	

}
