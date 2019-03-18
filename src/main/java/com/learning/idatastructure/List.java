/**
 * 
 */
package com.learning.idatastructure;

import java.util.Iterator;

/**
 * @author 609734641
 *
 */
public interface List<T> {

	public void add(T t);
	public T remove(T t);
	public boolean isEmpty();
	public int getSize();
	public Iterator<T> iterator();
}
