package fr.MelodyApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import fr.MelodyApp.model.Cake;
import fr.MelodyApp.model.OrderProduct;
import fr.MelodyApp.model.OrderProductPK;
import fr.MelodyApp.model.User;

public interface CakeRepository extends JpaRepository<Cake, Long> {}