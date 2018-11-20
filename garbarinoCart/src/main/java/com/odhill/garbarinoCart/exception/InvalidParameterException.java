package com.odhill.garbarinoCart.exception;

/**
 * 
 * @author odhill
 *
 */
public class InvalidParameterException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8585393162169639456L;
	
	public InvalidParameterException(String message) {
		super(message);
	}
	
	public InvalidParameterException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
