package com.learning.impl.datastructure;

import java.util.Iterator;

import com.learning.idatastructure.List;

public class ArrayListImpl<T> implements List<T> {

	private T[] arrList;
	private int top;

	public ArrayListImpl() {
		arrList = (T[]) (new Object[10]);
		top = -1;
	}

	@Override
	public void add(T t) {
		arrList[++top] = t;
	}

	@Override
	public T remove(T t) {
		for (int i = 0; i < top; i++) {
			if (arrList[i] == t) {
				arrList[i] = null;
				return t;
			}
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	@Override
	public int getSize() {
		return top + 1;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			int count = -1;

			@Override
			public boolean hasNext() {
				return count < top;
			}

			@Override
			public T next() {
				return arrList[++count];
			}
		};
	}

}
