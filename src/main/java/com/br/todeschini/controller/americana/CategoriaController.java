package com.br.todeschini.controller.americana;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.br.todeschini.model.americana.Categoria;
import com.br.todeschini.repository.americana.CategoriaRepository;
import com.br.todeschini.repository.americana.ObjetoRepository;

@Controller
public class CategoriaController {

	
	@Autowired
	CategoriaRepository catRep;
	
	@Autowired
	ObjetoRepository objRep;
	
	@RequestMapping("listacategorias")
	public String lista(Model model) {
		
		boolean erroMessage = false;
		model.addAttribute("erroMessage", erroMessage);
		carregarTabela(model);
		return "listacategorias";
	}
	
	@RequestMapping(value = "salvarCat", method = RequestMethod.POST )
	public String salvar(@RequestParam("nome") String nome){
		
		Categoria cat = new Categoria(nome);
		catRep.save(cat);
		
		return "redirect:/listacategorias";
		
	}
	
	@RequestMapping(value = "excluirCat/{id}", method = RequestMethod.GET)
	public String excluir(@PathVariable("id") Long id, Model model, HttpServletRequest request){
		
		Categoria cat = catRep.findOne(id);
		if(naoExisteObjetoVinculado(cat)){
			catRep.delete(cat);
			System.out.println("[Exclusão de categoria] Categoria: " + cat.getNome());
		}		
		return "redirect:/listacategorias";
		
	}
	
	private void carregarTabela(Model model) {
		Iterable<Categoria> categoria = catRep.findAll();
		model.addAttribute("categorias", categoria);
	}
	
	public boolean naoExisteObjetoVinculado(Categoria categoria){
		return objRep.findByCategoria(categoria).isEmpty();
	}

}
