/**
 * 
 */
package com.learning.impl.datastructure;

import java.util.Iterator;

import com.learning.exception.NoSuchElementException;
import com.learning.idatastructure.List;

/**
 * @author aadiyogis
 *
 */
public class LinkedListImpl<T> implements List<T> {

	private int size;
	private Node<T> head;

	private class Node<E> {
		Node<E> next;
		E element;
	}

	public LinkedListImpl() {
		head = null;
	}

	@Override
	public void add(T t) {
		Node<T> node = new Node<>();
		node.element = t;
		node.next = head;
		head = node;
		size++;
	}

	@Override
	public T remove(T t) {
		Node<T> pointer = head;
		T val = null;
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			Node<T> oldPointer = pointer;
			while (pointer != null) {
				if (pointer.element == t) {
					if (oldPointer == head) {
						head = oldPointer.next;
					} else {
						oldPointer.next = pointer.next;
					}
					val = pointer.element;
					size--;
					break;
				} else {
					oldPointer = pointer;
					pointer = pointer.next;
				}
			}
		}
		return val;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			Node<T> pointer = head;

			@Override
			public boolean hasNext() {
				return pointer != null;
			}

			@Override
			public T next() {
				T val = pointer.element;
				pointer = pointer.next;
				return val;
			}
		};
	}

	@Override
	public T get(int index) {
		T val;
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		} else {
			Node<T> pointer = head;
			for(int i=0; i<index; i++) {
				pointer = pointer.next;
			}
			val = pointer.element;
		}
		return val;
	}

}
