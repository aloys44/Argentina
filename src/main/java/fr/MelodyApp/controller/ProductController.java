package fr.MelodyApp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.MelodyApp.model.Product;
import fr.MelodyApp.services.ProductService;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/auth/products")
@CrossOrigin()
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = { "", "/" })
    public @NotNull Iterable<Product> getProducts() {
        return productService.getAllProducts();
    }
    
}