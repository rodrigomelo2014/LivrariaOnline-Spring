package br.com.casadocodigo.loja.daos;

import java.math.BigDecimal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.casadocodigo.loja.models.BookType;
import br.com.casadocodigo.loja.models.Product;

@Repository
public interface InterfaceDAO extends CrudRepository<Product, Integer> {
	
}
