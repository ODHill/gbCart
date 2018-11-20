package com.odhill.garbarinoCart.exception;

/**
 * 
 * @author odhill
 *
 */
public class NotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -505281653593437608L;
	
	public NotFoundException(String message) {
		super(message);
	}

	public NotFoundException(String message, Throwable throwable) {
		super(message, throwable);
	}
	
}
