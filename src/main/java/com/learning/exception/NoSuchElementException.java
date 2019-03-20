package com.learning.exception;

/**
 * @author aadiyogis
 *
 */
public class NoSuchElementException extends RuntimeException{

	private static final long serialVersionUID = -6159249470892731737L;
	
	public NoSuchElementException(String message) {
		super(message);
	}
	
	public NoSuchElementException() {
		super();
	}
}
