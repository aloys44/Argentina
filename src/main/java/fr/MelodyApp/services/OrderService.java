package fr.MelodyApp.services;


import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import fr.MelodyApp.model.Order;
import fr.MelodyApp.model.Product;

@Validated
public interface OrderService {

    @NotNull Iterable<Order> getAllOrders();
    
    Order getOrder(@Min(value = 1L, message = "Invalid order ID.") long id);

    Order create(@NotNull(message = "The order cannot be null.") @Valid Order order);

    void update(@NotNull(message = "The order cannot be null.") @Valid Order order);
}