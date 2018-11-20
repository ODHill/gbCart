package com.odhill.garbarinoCart.dto;

import java.io.Serializable;

/**
 * 
 * @author odhill
 *
 */
public class ProductDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1239500174671386815L;
	
	private Long idProduct;

	private float unitPrice;
	
	private int quantity;
	
	

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
	 * @return the unitPrice
	 */
	public float getUnitPrice() {
		return unitPrice;
	}

	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
