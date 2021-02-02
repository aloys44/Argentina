package fr.MelodyApp.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(	name = "cakes", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "name"),
			@UniqueConstraint(columnNames = "description") 
		})
public class Cake {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    
	@NotBlank
	@Size(max = 100)
	private String name;
	
	@NotBlank
	@Size(max = 300)
	private String description;
	
	@NotBlank
	private Integer price;
	
	private String photo;
	

	public Cake() {
	}

	public Cake(int id, @NotBlank @Size(max = 100) String name, @NotBlank @Size(max = 300) String description,
			@NotBlank Integer price, String photo) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.photo = photo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}



}
