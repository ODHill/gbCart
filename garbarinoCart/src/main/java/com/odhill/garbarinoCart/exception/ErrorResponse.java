package com.odhill.garbarinoCart.exception;

/**
 * 
 * @author odhill
 *
 */
public class ErrorResponse {

	private String errorMessage;
	
	private String details;
	
	public ErrorResponse(String errorMessage, String details) {

		this.errorMessage = errorMessage;
		this.details = details;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * @param details the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}
		


}
