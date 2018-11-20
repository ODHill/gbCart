package com.odhill.garbarinoCart.exception;

/**
 * 
 * @author odhill
 *
 */
public class BussinessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3421887003076331422L;
	
	public BussinessException(String message) {
		super(message);
	}
	
	public BussinessException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
