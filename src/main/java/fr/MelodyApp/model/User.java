package fr.MelodyApp.model;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(	name = "users", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "username"),
			@UniqueConstraint(columnNames = "email") 
		})
public class User {
	
	 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
	@NotBlank
	@Size(max = 200)
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;
	
	@NotBlank
	@Size(max = 200)
	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;

	@NotBlank
	@Size(max = 200)
	@Column(name = "USERNAME", nullable = false)
	private String username;
	
	@NotBlank
	@Size(max = 200)
	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@NotBlank
	@Size(max = 50)
	@Column(name = "EMAIL", nullable = false)
	private String email;

	@NotBlank
	@Size(max = 120)
	@Column(name = "ADRESS", nullable = false)
	private String adress;
	
	@NotBlank
	@Size(max = 120)
	@Column(name = "CITY", nullable = false)
	private String city;
	
	@NotBlank
	@Size(max = 120)
	@Column(name = "PHONE", nullable = false)
	private String phone;
	

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();



	public User() {
		super();
	}



	public User(@NotBlank @Size(max = 200) String firstName, @NotBlank @Size(max = 200) String lastName,
			@NotBlank @Size(max = 200) String username, @NotBlank @Size(max = 200) String password,
			@NotBlank @Size(max = 50) String email, @NotBlank @Size(max = 120) String adress,
			@NotBlank @Size(max = 120) String city, @NotBlank @Size(max = 120) String phone) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.adress = adress;
		this.city = city;
		this.phone = phone;

	}









	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + username + ", email=" + email + '}';
    }
}