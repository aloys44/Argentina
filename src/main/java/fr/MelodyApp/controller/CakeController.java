package fr.MelodyApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.MelodyApp.model.Cake;
import fr.MelodyApp.repository.CakeRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/order")
public class CakeController {
	
	@Autowired
	CakeRepository cakeRepository;

	
    @GetMapping("/getAllCakes")
    public List<Cake> findAllCakes() {
        return cakeRepository.findAll();
    }
	
}
