package com.odhill.garbarinoCart.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Embeddable
public class ProductInCartId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8769211358192669345L;

	@Column(name = "ID_PRODUCT")
	private Long product;
	
	@Column(name = "ID_CART")
	private Long cart;

	public Long getProduct() {
		return product;
	}

	public void setProduct(Long product) {
		this.product = product;
	}

	public Long getCart() {
		return cart;
	}

	public void setCart(Long cart) {
		this.cart = cart;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProductInCartId)) {
			return false;
		}
		
		ProductInCartId prodId = (ProductInCartId) obj;
		return new EqualsBuilder().append(this.product, prodId.product).append(this.cart, prodId.cart).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(product).append(cart).toHashCode();
	}
	
	
}
