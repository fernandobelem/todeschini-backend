package com.br.todeschini.restful.americana;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.todeschini.model.americana.Produto;
import com.br.todeschini.repository.americana.ProdutoRepository;


@RestController
public class AmericanaProdutoRestController{
	
	static final String CORS = "http://localhost:8000";
	
	@Autowired
	ProdutoRepository produtoRep;
	
	@CrossOrigin(origins=CORS)
	@RequestMapping("/selectProduto")
	public Produto selectProduto(
			@RequestParam(value = "id", defaultValue = "1") Long id){
		
		return produtoRep.findOne(id);
	}
	
	@CrossOrigin(origins=CORS)
	@RequestMapping("/selectTodosProdutos")
	public Iterable<Produto> selectTodosProdutos(){
		
		return produtoRep.findAll();
	}
	
	@RequestMapping("/inserirProduto")
	public void inserirProduto(@RequestParam(value = "name") String name, @RequestParam(value="desc") String desc){
		produtoRep.save(new Produto(name, desc));
	}


}
