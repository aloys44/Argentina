package fr.MelodyApp.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import fr.MelodyApp.model.Order;
import fr.MelodyApp.model.OrderProduct;
import fr.MelodyApp.model.OrderStatus;
import fr.MelodyApp.model.Product;
import fr.MelodyApp.repository.OrderProductRepository;
import fr.MelodyApp.repository.ProductRepository;
import fr.MelodyApp.services.OrderProductService;
import fr.MelodyApp.services.OrderService;
import fr.MelodyApp.services.ProductService;
import fr.MelodyApp.services.UserService;
import fr.dto.OrderProductDto;
import fr.exception.ResourceNotFoundException;

import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth/orders")
@CrossOrigin()
public class OrderController {

    ProductService productService;
    OrderService orderService;
    OrderProductService orderProductService;
    UserService userService;
    OrderProductRepository orderProductRepository;
    ProductRepository productRepository;

    public OrderController(ProductService productService, 
    		OrderService orderService, 
    		OrderProductService orderProductService,
    		OrderProductRepository orderProductRepository,
    	    ProductRepository productRepository

    		) {
        this.productService = productService;
        this.orderService = orderService;
        this.orderProductService = orderProductService;
        this.orderProductRepository = orderProductRepository;
        this.productRepository = productRepository;

    }
    @GetMapping("/getAllOrders")
    public Iterable<OrderProduct> listOrderActive() {
        return orderProductRepository.findByActiveFalse();
    }

    
    @GetMapping("/getListUserOrder")
    public @ResponseBody Iterable<OrderProduct> getUserOrderList(@RequestParam Integer id) {
        return orderProductRepository.findOrderProductByUser(id);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public @NotNull Iterable<Order> list() {
        return this.orderService.getAllOrders();
    }
    

    
    @GetMapping("/getAllProductOfAnOrder")
    public Iterable<Product> listProductActive(@RequestParam Long id) {
        return productRepository.findProductOrder(id);
    }
    
    
    @PostMapping
    public ResponseEntity<Order> create(@RequestBody OrderForm form) {
        List<OrderProductDto> formDtos = form.getProductOrders();
        validateProductsExistence(formDtos);
        Order order = new Order();
        order.setStatus(OrderStatus.PAID.name());
        order = this.orderService.create(order);

        
        List<OrderProduct> orderProducts = new ArrayList<>();
        for (OrderProductDto dto : formDtos) {
        	System.out.println(order.getTotalOrderPrice());
            orderProducts.add(orderProductService.create(new OrderProduct(order, productService.getProduct(dto
              .getProduct()
              .getId()),dto.getUser(), dto.getQuantity())));
        }
        

        order.setOrderProducts(orderProducts);
        order.setTotalPrice(order.getTotalPrice());

        this.orderService.update(order);

        String uri = ServletUriComponentsBuilder
          .fromCurrentServletMapping()
          .path("/orders/{id}")
          .buildAndExpand(order.getId())
          .toString();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", uri);

        return new ResponseEntity<>(order, headers, HttpStatus.CREATED);
    }



	private void validateProductsExistence(List<OrderProductDto> orderProducts) {
        List<OrderProductDto> list = orderProducts
          .stream()
          .filter(op -> Objects.isNull(productService.getProduct(op
            .getProduct()
            .getId())))
          .collect(Collectors.toList());

        if (!CollectionUtils.isEmpty(list)) {
            new ResourceNotFoundException("Product not found");
        }
    }

    public static class OrderForm {
    	
    	
        private List<OrderProductDto> productOrders;

        public List<OrderProductDto> getProductOrders() {
            return productOrders;
        }

        public void setProductOrders(List<OrderProductDto> productOrders) {
            this.productOrders = productOrders;
        }
    }
}