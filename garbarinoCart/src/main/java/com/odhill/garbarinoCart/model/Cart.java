package com.odhill.garbarinoCart.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author odhill
 *
 */
@Entity
@Table(name="CART")
@NamedQuery(name = Cart.QUERY_READY_CARTS, query = "SELECT cart.idCart FROM Cart cart WHERE cart.status = 'READY'")
public class Cart implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3346908416529170516L;
	
	public static final String QUERY_READY_CARTS = "cartReady";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_CART")
	private Long idCart;
    
	@Column(name = "FULL_NAME")
    private String fullName;
    
	@Column(name = "EMAIL")
    private String email;
    
	@Column(name = "CREATION_DATE")
	@Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

	@OneToMany(mappedBy = "cart", cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval=true)	
	private List<ProductInCart> products = new ArrayList<>();
    
	@Column(name = "TOTAL")
    private float total;
    

    @Enumerated(EnumType.STRING)
	@Column(name = "STATUS")
    private Status status;

    /**
     * @return el idCart
     */
    public Long getIdCart() {
        return idCart;
    }

    /**
     * @param idCart el idCart a establecer
     */
    public void setIdCart(Long idCart) {
        this.idCart = idCart;
    }

    /**
     * @return el fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName el fullName a establecer
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return el email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email el email a establecer
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return el creationDate
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * @param creationDate el creationDate a establecer
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * @return el total
     */
    public float getTotal() {
        return total;
    }

    /**
     * @param total el total a establecer
     */
    public void setTotal(float total) {
        this.total = total;
    }

    /**
     * @return el status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * @param status el status a establecer
     */
    public void setStatus(Status status) {
        this.status = status;
    }
    
    
    public ProductInCart containsProduct(Product product) {
    	return products.stream().filter(productInCart -> productInCart.getProduct().equals(product))
    			.findFirst().orElse(null);    	    	
    }    
    
    public void calculateTotal() {
    	total = (float) products.stream().mapToDouble(p -> p.getQuantity() * p.getUnitPrice()).sum();
    }

	public List<ProductInCart> getProducts() {
		return products;
	}

	public void setProducts(List<ProductInCart> products) {
		this.products = products;
	}
	
	public void addProduct(ProductInCart productInCart) {
		this.products.add(productInCart);
	}	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Cart)) {
			return false;
		}
		
		Cart prodInCart = (Cart) obj;
		return new EqualsBuilder().append(this.idCart, prodInCart.idCart).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.idCart).toHashCode();
	} 
    
}
