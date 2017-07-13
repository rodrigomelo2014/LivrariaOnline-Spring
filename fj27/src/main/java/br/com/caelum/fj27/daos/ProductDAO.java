package br.com.caelum.fj27.daos;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.caelum.fj27.models.BookType;
import br.com.caelum.fj27.models.Product;

@Repository
public class ProductDAO {
	@PersistenceContext
	private EntityManager manager;
	
	public void save(Product product){
		manager.persist(product);
	}
	
	public List<Product> list(){
		return manager.createQuery("SELECT DISTINCT(p) FROM Product p JOIN FETCH p.prices", Product.class).getResultList();
	}
	
	public BigDecimal sumPricesPerType(BookType bookType){
		TypedQuery<BigDecimal> query = manager.createQuery(
				"SELECT SUM(price.value) FROM Product p JOIN p.prices price WHERE price.bookType = :bookType", BigDecimal.class);
		
		query.setParameter("bookType", bookType);
		return query.getSingleResult();
	}
}
