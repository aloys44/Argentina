package fr.MelodyApp.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.MelodyApp.model.Order;
import fr.MelodyApp.repository.OrderRepository;
import fr.exception.ResourceNotFoundException;

import java.time.LocalDate;

import javax.validation.constraints.Min;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Iterable<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }

    @Override
    public Order create(Order order) {
        order.setDateCreated(LocalDate.now());

        return this.orderRepository.save(order);
    }

    @Override
    public void update(Order order) {
        this.orderRepository.save(order);
    }

	@Override
	public Order getOrder(@Min(value = 1, message = "Invalid order ID.") long id) {
		return this.orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Notice not found"));
	}
}