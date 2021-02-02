package fr.dto;

import fr.MelodyApp.model.Product;
import fr.MelodyApp.model.User;

public class OrderProductDto {

    private Product product;
    private Integer user;
    private Integer quantity;
    private int priceTotal;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

	public Integer getUser() {
		return user;
	}

	public void setUser(Integer user) {
		this.user = user;
	}

	public int getPriceTotal() {
		return priceTotal;
	}

	public void setPriceTotal(int priceTotal) {
		this.priceTotal = priceTotal;
	}
    

    
    
}