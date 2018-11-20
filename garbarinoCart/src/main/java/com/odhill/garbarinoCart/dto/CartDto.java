package com.odhill.garbarinoCart.dto;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.odhill.garbarinoCart.model.ProductInCart;

/**
 * 
 * @author odhill
 *
 */
public class CartDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5105799551594296715L;

	private Long idCart;    
	
    private String fullName;
    
    private String email;
    
    private String creationDate;

	private List<String> products = new ArrayList<>();
    
    private float total;
    
    private String status;

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

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the creationDate
	 */
	public String getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
		this.creationDate = format.format(creationDate);

	}

	/**
	 * @return the productos
	 */
	public List<String> getProducts() {
		return products;
	}

	/**
	 * @param productos the productos to set
	 */
	public void setProducts(List<ProductInCart> products) {
		this.products.addAll(products.stream().map(p -> p.getProduct().getIdProduct().toString())
				.collect(Collectors.toList()));	
	}

	/**
	 * @return the total
	 */
	public float getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(float total) {
		this.total = total;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
    
    

}
