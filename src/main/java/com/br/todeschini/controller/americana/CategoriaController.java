package com.br.todeschini.controller.americana;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.br.todeschini.model.americana.Categoria;
import com.br.todeschini.repository.americana.CategoriaRepository;

@Controller
public class CategoriaController {

	
	@Autowired
	CategoriaRepository catRep;
	
	
	@RequestMapping("listacategorias")
	public String lista(Model model) {
		carregarTabela(model);
		return "listacategorias";
	}
	
	@RequestMapping(value = "salvarCat", method = RequestMethod.POST )
	public String salvar(@RequestParam("nome") String nome, Model model){
		
		Categoria cat = new Categoria(nome);
		catRep.save(cat);
		
		return "redirect:/listacategorias";
		
	}
	
	@RequestMapping(value = "excluirCat/{id}", method = RequestMethod.GET)
	public String excluir(@PathVariable("id") Long id, Model model){
		
		Categoria cat = catRep.findOne(id);
		catRep.delete(cat);
		System.out.println("[Exclusão de categoria] Categoria: " + cat.getNome());
		
		return "redirect:/listacategorias";
		
	}

	private void carregarTabela(Model model) {
		Iterable<Categoria> categoria = catRep.findAll();
		model.addAttribute("categorias", categoria);
	}

}
