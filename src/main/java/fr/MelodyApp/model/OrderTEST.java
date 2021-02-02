package fr.MelodyApp.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


public class OrderTEST {

	@Id
	@GeneratedValue
	private int id;

	@NotNull
	private Date deliverDate;

	private Date orderingDate;

	@NotNull
	private int totalPrice;

	private int user_id;

	@Column
	@ElementCollection(targetClass = Integer.class)
	private List<Integer> listCakes;



}
