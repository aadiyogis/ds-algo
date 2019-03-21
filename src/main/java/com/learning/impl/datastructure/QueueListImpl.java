/**
 * 
 */
package com.learning.impl.datastructure;

import java.util.Iterator;

import com.learning.exception.NoSuchElementException;
import com.learning.idatastructure.Queue;

/**
 * @author aadiyogis
 *
 */
public class QueueListImpl<T> implements Queue<T> {

	private int size;
	private Node<T> head;

	private class Node<E> {
		Node<E> next;
		E element;
	}

	private void add(T element) {
		Node<T> node = new Node<>();
		node.element = element;
		node.next = null;
		if (head == null) {
			head = node;
		} else {
			Node<T> pointer = head;
			while (pointer.next != null) {
				pointer = pointer.next;
			}
			pointer.next = node;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.learning.idatastructure.Queue#enque(java.lang.Object)
	 */
	@Override
	public boolean enque(T element) throws IllegalArgumentException {
		add(element);
		size++;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.learning.idatastructure.Queue#dequeue()
	 */
	@Override
	public T dequeue() {
		if(!isEmpty()) {
			T val = head.element;
			head = head.next;
			size--;
			return val;
		}else {
			throw new NoSuchElementException();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.learning.idatastructure.Queue#size()
	 */
	@Override
	public int size() {
		return size;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.learning.idatastructure.Queue#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.learning.idatastructure.Queue#iterator()
	 */
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

}
