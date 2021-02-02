package fr.MelodyApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.MelodyApp.model.ERole;
import fr.MelodyApp.model.Role;
import fr.MelodyApp.model.User;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}