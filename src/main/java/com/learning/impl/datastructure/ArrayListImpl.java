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
		T val = null;
		for (int i = 0; i <= top; i++) {
			if (arrList[i] == t) {
				val = arrList[i];
				arrList[i] = null;
				arrList = squash(arrList);
				top--;
			}
		}
		return val;
	}

	private T[] squash(T[] arrList) {
		int size = arrList.length;
		T[] arrTemp = (T[]) (new Object[size - 1]);
		boolean flag = true;
		for (int i = 0; i < size; i++) {
			if (flag && arrList[i] != null) {
				arrTemp[i] = arrList[i];
			} else {
				flag = false;
				if (i + 1 < size) {
					arrTemp[i] = arrList[i + 1];
				}
			}
		}
		return arrTemp;
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

	@Override
	public T get(int index) {
		if (index > top + 1 || index < 0) {
			throw new IndexOutOfBoundsException();
		} else {
			return arrList[index];
		}
	}

	private void printArr(T[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i].toString());
		}
	}

}
