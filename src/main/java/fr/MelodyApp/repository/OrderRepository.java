package fr.MelodyApp.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.MelodyApp.model.Order;
import fr.MelodyApp.model.OrderProduct;
import fr.MelodyApp.model.User;

public interface OrderRepository extends CrudRepository<Order, Long> {
	

}