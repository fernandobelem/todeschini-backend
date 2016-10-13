package com.br.todeschini.controller.americana;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.br.todeschini.model.americana.Categoria;
import com.br.todeschini.model.americana.ObjetosAmbiente;
import com.br.todeschini.repository.americana.CategoriaRepository;
import com.br.todeschini.repository.americana.ObjetoRepository;

@Controller
public class ObjetosController {
	
	@Autowired
	ObjetoRepository objRep;
	
	@Autowired
	CategoriaRepository catRep;
	
	@RequestMapping("listaobjetos")
	public String lista(Model model) {
		carregarListaObjetos(model);
		carregarCategorias(model);
		return "listaobjetos";
	}
	
	private void carregarListaObjetos(Model model){
		Iterable<ObjetosAmbiente> objs = objRep.findAll();
		model.addAttribute("objs", objs);
	}
	
	private void carregarCategorias(Model model){
		Iterable<Categoria> cats = catRep.findAll();
		model.addAttribute("cats", cats);
	}

	@RequestMapping(value = "salvarObj", method = RequestMethod.POST )
	public String salvarObjeto(@RequestParam("nomeObjeto") String nomeObjeto, @RequestParam("nomeCategoria")String nomeCategoria, 
			 Model model){
		
		ObjetosAmbiente novoObjeto = new ObjetosAmbiente(nomeObjeto, catRep.findByNome(nomeCategoria));
		objRep.save(novoObjeto);
		System.out.println("[Salvando Objeto] : " + nomeObjeto + "/" + nomeCategoria);

		return "redirect:/listaobjetos";
		
	}
	
	@RequestMapping(value = "excluirObj/{id}", method = RequestMethod.GET)
	public String excluir(@PathVariable("id") Long id, Model model){
		
		
		ObjetosAmbiente obj = objRep.findOne(id);
		objRep.delete(obj);
		System.out.println("[Exclusao Objeto] : " + obj.getNome());
		
		return "redirect:/listaobjetos";
		
	}
}
