package com.br.todeschini.repository.americana;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.todeschini.model.americana.Categoria;
import com.br.todeschini.model.americana.ObjetosAmbiente;

@Repository
public interface ObjetoRepository extends CrudRepository<ObjetosAmbiente, Long> {
	
	public List<ObjetosAmbiente> findByCategoria(Categoria categoria);

}
