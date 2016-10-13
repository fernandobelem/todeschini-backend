package com.br.todeschini.repository.americana;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.todeschini.model.americana.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
	
	public Categoria findByNome(String nome);

}
