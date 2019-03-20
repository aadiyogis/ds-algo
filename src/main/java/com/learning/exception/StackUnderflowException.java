package com.learning.exception;

/**
 * @author aadiyogis
 * Exception class when stack underflow situation comes 
 */
public class StackUnderflowException extends Exception {

	private static final long serialVersionUID = 6609896142990695553L;

	public StackUnderflowException(String message) {
        super(message);
        System.out.println("exception is: "+message);
    }
}
