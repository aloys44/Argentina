package fr.MelodyApp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fr.MelodyApp.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

	@Query("SELECT o FROM Product o WHERE o.id=:id")
	public Iterable<Product> findProductOrder(
			  @Param("id") Long id);

}