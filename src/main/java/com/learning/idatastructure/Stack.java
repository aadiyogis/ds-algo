package com.learning.idatastructure;

import java.util.Iterator;

import com.learning.exception.StackUnderflowException;

public interface Stack<T> {
	public void push(T element);
	public T pop() throws StackUnderflowException;
	public boolean isEmpty();
	public int size();
	public <E> Iterator<T> iterator();
}
