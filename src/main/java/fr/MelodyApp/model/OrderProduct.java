package fr.MelodyApp.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name="OrderProduct")
public class OrderProduct {

    @EmbeddedId
    @JsonIgnore
    private OrderProductPK pk;

    @Column(name="QUANTITY", nullable = false) private Integer quantity;
    
    @Column(name="USER", nullable = false) private Integer user;

    @Column(name="ORDERING_DATE", nullable = true) private Date dateOrdering;
    
    @Column(name="DELIVER_DATE", nullable = true) private Date dateDeliver;
        
    private boolean active;

    public OrderProduct() {
		super();
	}

	public OrderProduct(Order order, Product product,Integer user, Integer quantity) {
        pk = new OrderProductPK();
        pk.setOrder(order);
        pk.setProduct(product);
        this.user = user;
        this.quantity = quantity;

    }


	@Transient
    public Product getProduct() {
        return this.pk.getProduct();
    }

    
    public Double getTotalPrice() {
        return getProduct().getPrice() * getQuantity();
    }

    public OrderProductPK getPk() {
        return pk;
    }

    public void setPk(OrderProductPK pk) {
        this.pk = pk;
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
	
	public Date getDateOrdering() {
		return dateOrdering;
	}

	public void setDateOrdering(Date dateOrdering) {
		this.dateOrdering = dateOrdering;
	}

	public Date getDateDeliver() {
		return dateDeliver;
	}

	public void setDateDeliver(Date dateDeliver) {
		this.dateDeliver = dateDeliver;
	}
	


	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((pk == null) ? 0 : pk.hashCode());

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        OrderProduct other = (OrderProduct) obj;
        if (pk == null) {
            if (other.pk != null) {
                return false;
            }
        } else if (!pk.equals(other.pk)) {
            return false;
        }

        return true;
    }

	public OrderProduct orElseThrow(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
}
