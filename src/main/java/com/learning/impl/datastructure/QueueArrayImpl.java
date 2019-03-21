/**
 * 
 */
package com.learning.impl.datastructure;

import java.util.Iterator;

import com.learning.idatastructure.Queue;

/**
 * @author aadiyogis
 *
 */
public class QueueArrayImpl<T> implements Queue<T> {

	private int size;
	private T[] arr;

	public QueueArrayImpl() {
		this(10);
	}

	public QueueArrayImpl(int size) {
		arr = (T[]) new Object[size];
	}

	@Override
	public boolean enque(T element) throws IllegalArgumentException {
		if (size == arr.length) {
			throw new IllegalArgumentException();
		} else {
			arr[size++] = element;
			return true;
		}
	}

	@Override
	public T dequeue() {
		size--;
		T val = arr[0];
		arr[0] = null;
		squash();
		return val;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			int point = 0;
			int count = size;

			@Override
			public boolean hasNext() {
				return count > 0;
			}

			@Override
			public T next() {
				count--;
				return arr[point++];
			}

		};
	}

	private void squash() {
		int size = arr.length;
		T[] array = (T[]) new Object[size];
		for (int i = 0; i < size - 1; i++) {
			array[i] = arr[i + 1];
		}
		arr = array;
	}

}
