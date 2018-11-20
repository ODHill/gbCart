package com.odhill.garbarinoCart.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author odhill
 *
 */
@Entity
@Table(name="PRODUCT")
public class Product implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 5576421704170116279L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_PRODUCT")
	private Long idProduct;
    
	@Column(name = "DESCRIPTION")
    private String description;
    
	@Column(name = "UNIT_PRICE")
    private float unitPrice;
    
	@Column(name = "STOCK")
    private int stock;

    /**
     * @return el idProduct
     */
    public Long getIdProduct() {
        return idProduct;
    }

    /**
     * @param idProduct el idProduct a establecer
     */
    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    /**
     * @return el description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description el description a establecer
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return el unitPrice
     */
    public float getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice el unitPrice a establecer
     */
    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @return el stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock el stock a establecer
     */
    public void setStock(int stock) {
        this.stock = stock;
    }


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Product)) {
			return false;
		}
		
		Product prod = (Product) obj;
		return new EqualsBuilder().append(this.idProduct, prod.idProduct).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(idProduct).toHashCode();
	}
    
    
}
