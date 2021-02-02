package fr.MelodyApp.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import fr.MelodyApp.model.OrderProduct;
import fr.MelodyApp.model.OrderProductPK;

@Repository
public interface OrderProductRepository extends CrudRepository<OrderProduct, OrderProductPK> {

	@Query("SELECT o FROM OrderProduct o  WHERE o.active = 0")
	public Iterable<OrderProduct> findByActiveFalse();
	
	@Query("SELECT o FROM OrderProduct o WHERE o.user=:id")
	public Iterable<OrderProduct> findOrderProductByUser(
	  @Param("id") Integer id);

}