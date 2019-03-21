/**
 * 
 */
package com.learning.idatastructure;

import java.util.Iterator;

/**
 * @author aadiyogis
 * An interface for First in first out order of removal 
 */
public interface Queue<T> {

	/**
	 * Adds element to queue
	 * @param element
	 * @return true if element added successfully
	 * @throws IllegalArgumentException
	 */
	public boolean enque(T element) throws IllegalArgumentException;
	
	/**
	 * Removes element
	 * @return
	 */
	public T dequeue();
	
	/**
	 * get the count of element in queue
	 * @return
	 */
	public int size();
	
	/**
	 * Check whether queue is empty or not
	 * @return
	 */
	public boolean isEmpty();
	
	/**
	 * Iterator for iterating over elements of queue
	 * @return
	 */
	public Iterator<T> iterator();
}
