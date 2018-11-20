package com.odhill.garbarinoCart.dto;

import java.io.Serializable;

/**
 * 
 * @author odhill
 *
 */
public class ProductInCartDto implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -3037150155410263325L;

	private Long idProduct;
	
	private Long idCart;
	
	private float unitPrice;
	
	private int quantity;
	
	public ProductInCartDto(Long idProduct, Long idCart, float unitPrice, int quantity) {
		this.idProduct = idProduct;
		this.idCart = idCart;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		
	}


	/**
	 * @return the idProduct
	 */
	public Long getIdProduct() {
		return idProduct;
	}

	/**
	 * @param idProduct the idProduct to set
	 */
	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	/**
	 * @return the idCart
	 */
	public Long getIdCart() {
		return idCart;
	}

	/**
	 * @param idCart the idCart to set
	 */
	public void setIdCart(Long idCart) {
		this.idCart = idCart;
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
	
}
