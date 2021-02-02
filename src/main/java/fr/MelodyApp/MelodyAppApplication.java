package fr.MelodyApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fr.MelodyApp.model.Product;
import fr.MelodyApp.model.Role;
import fr.MelodyApp.services.ProductService;
import fr.MelodyApp.services.RoleService;

@SpringBootApplication
public class MelodyAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MelodyAppApplication.class, args);
	}
	
	 @Bean
	    CommandLineRunner runner(ProductService productService) {
	        return args -> {
	            productService.save(new Product(1L, "Gateau aux noix", 10.00, "gateauNoix.jpg","[813079.7791264898, 5929220.284081122]"));
	            productService.save(new Product(2L, "Fraisier", 10.00, "fraisier.jpg","[813079.7791264898, 5929220.284081122]"));
	            productService.save(new Product(3L, "Tiramisu", 15.00, "tiramisu.jpg","[813079.7791264898, 5929220.284081122]"));
	            productService.save(new Product(4L, "Forêt noire", 15.00, "foret-noire.jpg","[813079.7791264898, 5929220.284081122]"));
	            productService.save(new Product(5L, "Paris-Brest", 13.00, "paris-brest.jpeg","[813079.7791264898, 5929220.284081122]"));
	            productService.save(new Product(6L, "Flan Patissier", 10.00, "flan patissier.jpg","[813079.7791264898, 5929220.284081122]"));
	            productService.save(new Product(7L, "Crumble aux pommes", 15.00, "crumbleAuxPommes.jpg","[813079.7791264898, 5929220.284081122]"));
	            productService.save(new Product(8L, "Clafoutis aux cerises", 16.00, "calfoutis.jpg","[813079.7791264898, 5929220.284081122]"));
	            productService.save(new Product(9L, "Gateau de noël allemand", 20.00, "linzer-torte.jpg","[813079.7791264898, 5929220.284081122]"));

	        };
	    }
	 
	


}
