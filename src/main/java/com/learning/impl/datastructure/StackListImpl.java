package com.learning.impl.datastructure;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

import com.learning.exception.StackUnderflowException;
import com.learning.idatastructure.Stack;

public class StackListImpl<T> implements Stack<T> {

	private class Node<E> {
		Node<E> next;
		E element;
	}

	private Node<T> root;
	private AtomicInteger count;

	public StackListImpl() {
		root = null;
		count = new AtomicInteger(0);
	}

	public <E> Iterator<T> iterator() {
		return new Iterator<T>() {
			Node<T> itrRoot = root;

			@Override
			public boolean hasNext() {
				return itrRoot != null;
			}

			@Override
			public T next() {
				T ele = itrRoot.element;
				itrRoot = itrRoot.next;
				return ele;
			}
		};

	}

	@Override
	public void push(T element) {
		Node<T> node = new Node<>();
		node.element = element;
		synchronized (node) {
			node.next = root;
			root = node;
			count.incrementAndGet();
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		if(!isEmpty()) {
			synchronized (root) {
				count.decrementAndGet();
				T element = root.element;
				root = root.next;
				return element;
			}
		}else {
			throw new StackUnderflowException("Stack is empty");
		}
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public int size() {
		return count.get();
	}
}
