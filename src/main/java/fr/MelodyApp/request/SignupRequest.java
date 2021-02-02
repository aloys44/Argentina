package fr.MelodyApp.request;

import java.util.Set;

import javax.validation.constraints.*;
 
public class SignupRequest {
	
	
    @NotBlank
    @Size(min = 3, max = 50)
    private String firstName;
    
    @NotBlank
    @Size(min = 3, max = 50)
    private String lastName;
	
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
 
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    
    @NotBlank
    @Size(min = 3, max = 100)
    private String adress;
    
    @NotBlank
    @Size(min = 3, max = 100)
    private String city;
    
    @NotBlank
    @Size(min = 3, max = 50)
    private String phone;
    
    private Set<String> role;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Set<String> getRole() {
		return role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}
    
  
  
}