package com.br.todeschini.controller.americana;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.br.todeschini.model.americana.Produto;
import com.br.todeschini.repository.americana.ProdutoRepository;

@Controller
public class ProdutosController {

	@Autowired
	ProdutoRepository rep;

	@RequestMapping("listaprodutos")
	public String lista(Model model) {
		carregarTabela(model);
		return "listaprodutos";
	}

	@RequestMapping(value = "salvarProd", method = RequestMethod.POST)
	public String salvar(@RequestParam("nome") String nome,
			@RequestParam("descricao") String descricao, Model model) {

		Produto novoProduto = new Produto(nome, descricao);
		rep.save(novoProduto);

		return "redirect:/listaprodutos";
	}


	@RequestMapping(value = "excluirProd/{id}", method = RequestMethod.GET)
	public String excluir(@PathVariable("id") Long id, Model model) {

		System.out.println("Exclusao solicitada para id: " + id);

		Produto prod = rep.findOne(id);
		rep.delete(prod);

		return "redirect:/listaprodutos";
	}

	private void carregarTabela(Model model) {
		Iterable<Produto> produtos = rep.findAll();
		model.addAttribute("produtos", produtos);
	}

}
