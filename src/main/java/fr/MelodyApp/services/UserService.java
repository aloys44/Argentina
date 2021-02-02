package fr.MelodyApp.services;

import javax.validation.constraints.Min;

import org.springframework.validation.annotation.Validated;

import fr.MelodyApp.model.Product;
import fr.MelodyApp.model.User;

@Validated
public interface UserService {
	
    User getUser(@Min(value = 1L, message = "Invalid user ID.") long id);


}
