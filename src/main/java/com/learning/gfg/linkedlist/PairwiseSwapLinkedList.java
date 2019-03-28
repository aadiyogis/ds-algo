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
public class PairwiseSwapLinkedList {

	private Node head;
	
	private class Node{
		Node next;
		String element;
	}
	
	public void addAll(String[] arrs) {
		for (int i = 0; i < arrs.length; i++) {
			add(arrs[i]);
		}
	}

	private void add(String val) {
		Node node = new Node();
		node.element = val;
		node.next = null;
		if(head == null) {
			head = node;
		} else {
			Node first = head;
			while(first.next != null) {
				first = first.next;
			}
			first.next = node;
		}
	}

	public void pairwiseswap() {
		Node first = head;
		while(first != null && first.next != null) {
			String val = first.element;
			first.element = first.next.element;
			first.next.element = val;
			first = first.next.next;
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
				if(first == null) {
					throw new NoSuchElementException();
				}
				String val = first.element;
				first = first.next;
				return val;
			}
			
		};
	}

}
