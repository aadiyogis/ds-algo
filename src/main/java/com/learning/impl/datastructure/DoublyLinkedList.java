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
public class DoublyLinkedList<T> implements List<T>, Iterable<T> {

	private int size;
	private Node<T> first;
	private Node<T> last;

	private class Node<E> {
		Node<E> next;
		Node<E> prev;
		E element;
	}

	@Override
	public void add(T t) {
		Node<T> node = new Node<>();
		node.element = t;
		if (first == null && last == null) {
			node.next = null;
			node.prev = null;
			first = node;
			last = node;
		} else {
			node.next = first;
			first.prev = node;
			node.prev = null;
			first = node;
		}
		size++;
	}

	@Override
	public T remove(T t) {
		T val = null;
		Node<T> pointer = first;
		while (pointer != null) {
			if (t == pointer.element) {
				val = pointer.element;
				Node<T> prev = pointer.prev;
				Node<T> next = pointer.next;
				if (prev != null) {
					prev.next = next;
				}
				if (next != null) {
					next.prev = prev;
				}
				pointer.prev = null;
				pointer.next = null;
				pointer = null;
				size--;
			} else {
				pointer = pointer.next;
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

			Node<T> pointer = first;

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
		T val = null;
		if (index < 0 || index >= size) {
			throw new NoSuchElementException();
		} else {
			int count = -1;
			Iterator<T> iterator = iterator();
			while (iterator.hasNext()) {
				count++;
				val = iterator.next();
				if (count == index) {
					break;
				}
			}
		}
		return val;
	}

}
