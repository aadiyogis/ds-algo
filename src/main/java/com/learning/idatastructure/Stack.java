package com.learning.idatastructure;

import java.util.Iterator;

import com.learning.exception.StackUnderflowException;

public interface Stack<T> {
	/**
	 * Add element to stack.
	 * @param element
	 */
	public void push(T element);
	
	/**
	 * Returns most recently added element.
	 * @return most recently added element
	 * @throws StackUnderflowException when stack is empty and pop operation is called
	 */
	public T pop() throws StackUnderflowException;
	
	/**
	 * check for emptyness of stack
	 * @return status if stack is empty or not
	 */
	public boolean isEmpty();
	
	/**
	 * size of stack at any given instance.
	 * @return size
	 */
	public int size();
	
	/**
	 * Iterator should iterate in order of Last in, first out. 
	 * It should iterate from latest element added to oldest element in stack.
	 * @return iterator to iterate on stack.
	 */
	public <E> Iterator<T> iterator();
}
