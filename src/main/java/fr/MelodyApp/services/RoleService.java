package fr.MelodyApp.services;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import fr.MelodyApp.model.OrderProduct;
import fr.MelodyApp.model.Product;
import fr.MelodyApp.model.Role;

@Validated
public interface RoleService {

	RoleService create(@NotNull(message = "The role cannot be null.") @Valid RoleService roleService);

	Role save(Role role);
}