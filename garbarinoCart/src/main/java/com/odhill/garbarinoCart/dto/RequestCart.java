package com.odhill.garbarinoCart.dto;

import java.io.Serializable;

/**
 * 
 * @author odhill
 *
 */
public class RequestCart implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -8631283260717426669L;
	
	private String fullName;
	
	private String email;

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

	

}
