package com.odhill.garbarinoCart.dto;

import java.io.Serializable;

/**
 * @author odhill
 *
 */
public class GenericResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9083871088125602472L;
	
	private String message;
	
	public GenericResponse(String message) {
		this.message = message;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
