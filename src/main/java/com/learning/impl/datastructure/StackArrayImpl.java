/**
 * 
 */
package com.learning.impl.datastructure;

import java.util.Iterator;

import com.learning.exception.StackUnderflowException;
import com.learning.idatastructure.Stack;

/**
 * @author 609734641
 *
 */
public class StackArrayImpl<T> implements Stack<T> {

	private T[] elements;
	private int top;

	public StackArrayImpl() {
		top = -1;
		elements = (T[]) new Object[10];
	}

	public StackArrayImpl(int size) {
		top = -1;
		elements = (T[]) new Object[size];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.learning.idatastructure.Stack#push(java.lang.Object)
	 */
	@Override
	public void push(T element) {
		if (elements.length - 1 == top) {
			resize(elements);
		}
		elements[++top] = element;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.learning.idatastructure.Stack#pop()
	 */
	@Override
	public T pop() throws StackUnderflowException {
		if (this.isEmpty()) {
			throw new StackUnderflowException("current stack is empty");
		}
		return elements[top--];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.learning.idatastructure.Stack#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.learning.idatastructure.Stack#size()
	 */
	@Override
	public int size() {
		return top+1;
	}

	@Override
	public <E> Iterator<T> iterator() {
		return new Iterator<T>() {
			int count = -1;

			@Override
			public boolean hasNext() {
				return count < top;
			}

			@Override
			public T next() {
				return elements[++count];
			}
		};
	}

	/**
	 * Resizing of array for internal expansion and reduction
	 * 
	 * @param arr
	 */
	private void resize(T[] arr) {
		int size = arr.length;
		int resized = size;
		if (top - 1 == size) {
			resized = 2 * size;
		}
		if ((size / 4) > top) {
			resized = size / 2;
		}
		T[] resizedArr = (T[]) (new Object[resized]);
		for (int i = 0; i < size; i++) {
			resizedArr[i] = arr[i];
		}
		arr = resizedArr;
	}
}
