/**
 * 
 */
package com.learning.gfg.linkedlist;

import java.util.Iterator;

import com.learning.exception.NoSuchElementException;

/**
 * @author aadiyogis
 *
 */
public class NnodeFromEndLinkedList {

	private Node head;

	private class Node {
		Node next;
		String element;
	}

	public void add(String element) {
		Node node = new Node();
		node.element = element;
		node.next = null;

		if (head == null) {
			head = node;
		} else {
			Node first = head;
			while (first.next != null) {
				first = first.next;
			}
			first.next = node;
		}
	}

	public Iterator<String> iterator() {
		return new Iterator<String>() {

			Node first = head;

			@Override
			public boolean hasNext() {
				return first != null;
			}

			@Override
			public String next() {
				if (first == null) {
					throw new NoSuchElementException();
				}
				String val = first.element;
				first = first.next;
				return val;
			}

		};
	}
	
	/**
	 * Size based algorithm
	 * @param n
	 * @return
	 */
	public String findNthElementFromEndBruteForce(int n) {
		String val = null;
		Node first = head;
		int count = 0;
		while (first != null) {
			count++;
			first = first.next;
		}
		if(n > count) {
			throw new IndexOutOfBoundsException();
		} else {
			int counter = count - n;
			first = head;
			for( int i=0; i<counter; i++) {
				first = first.next;
			}
			val = first.element;
		}
		return val;
	}
	
	public String findNthElementFromEndOptimized(int n) {
		String val = null;
		Node first = head;
		Node advance = head;
		for(int i=0; i<n; i++) {
			if(advance != null) {
				advance = advance.next;
			} else {
				throw new IndexOutOfBoundsException();
			}
		}
		while(advance != null) {
			advance = advance.next;
			first = first.next;
		}
		val = first.element;
		return val;
	}
}
