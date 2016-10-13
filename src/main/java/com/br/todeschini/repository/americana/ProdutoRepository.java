package com.br.todeschini.repository.americana;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.todeschini.model.americana.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {

}
