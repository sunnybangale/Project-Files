package com.cts.cbc.exceptions;

/**
 * The Class BusinessException.
 */
public class BusinessException extends Exception {

	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Instantiates a new business exception.
	 *
	 * @param message the message
	 */
	public BusinessException(final String message) {
		super(message);
	}
}
