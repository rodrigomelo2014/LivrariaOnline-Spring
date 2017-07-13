package br.com.caelum.fj27.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.caelum.fj27.models.Product;

@Repository
public interface InterfaceDAO extends CrudRepository<Product, Integer> {
	
}
