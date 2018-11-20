package com.odhill.garbarinoCart.exception;

/**
 * 
 * @author odhill
 *
 */
public class DaoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6137617430888589519L;
	
	public DaoException(String message) {
		super(message);
	}
	
	public DaoException(String message, Throwable throwable) {
		super(message, throwable);
	}
	
}
