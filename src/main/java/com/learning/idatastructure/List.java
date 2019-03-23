/**
 * 
 */
package com.learning.idatastructure;

import java.util.Iterator;

/**
 * @author aadiyogis
 *
 */
public interface List<T> {

	/**
	 * Adds element to list
	 * @param t
	 */
	public void add(T t);
	
	/**
	 * Remove given element from list
	 * @param element to be remove
	 * @return  element
	 */
	public T remove(T t);
	
	/**
	 * Check for list being empty 
	 * @return true if list is empty, else false
	 */
	public boolean isEmpty();
	
	/**
	 * count of elements present 
	 * @return
	 */
	public int getSize();
	
	/**
	 * Iterator to iterate on list
	 * @return Iterator instance on the current list
	 */
	public Iterator<T> iterator();
	
	/**
	 * Returns element present on index i.
	 * Index is starting from 0
	 * @param index
	 * @return
	 */
	public T get(int index);
}
