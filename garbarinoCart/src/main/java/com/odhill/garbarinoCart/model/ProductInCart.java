package com.odhill.garbarinoCart.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name="PRODUCT_IN_CART")
@NamedQuery(name = ProductInCart.QUERY_PRODUCTS_BY_CART_ID,
		 query = "SELECT new com.odhill.garbarinoCart.dto.ProductInCartDto(p.product.idProduct, p.cart.idCart, p.unitPrice, p.quantity) FROM ProductInCart p WHERE p.cart.idCart = :idCart")
public class ProductInCart implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5641128898462156594L;
	
	public static final String QUERY_PRODUCTS_BY_CART_ID = "productByCartID";

	@EmbeddedId
	private ProductInCartId productInCartId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PRODUCT", insertable =false, updatable=false)
	private Product product;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CART", insertable =false, updatable=false)
	private Cart cart;
	
	@Column(name = "UNIT_PRICE")
	private float unitPrice;
	
	@Column(name = "QUANTITY")
	private int quantity;
	
	@PrePersist
	private void createId() {
		productInCartId = new ProductInCartId();
		productInCartId.setCart(cart.getIdCart());
		productInCartId.setProduct(product.getIdProduct());
		
	}

    public void addItem() {
    	this.quantity++;        
    }

	public ProductInCartId getProductInCartId() {
		return productInCartId;
	}

	public void setProductInCartId(ProductInCartId productInCartId) {
		this.productInCartId = productInCartId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProductInCart)) {
			return false;
		}
		
		ProductInCart prodInCart = (ProductInCart) obj;
		return new EqualsBuilder().append(this.productInCartId, prodInCart.productInCartId).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.productInCartId).toHashCode();
	}      

}
