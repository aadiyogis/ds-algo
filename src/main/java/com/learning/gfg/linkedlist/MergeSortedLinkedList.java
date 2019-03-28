/**
 * 
 */
package com.learning.gfg.linkedlist;

import java.util.Iterator;

/**
 * @author aadiyogis
 *
 */
public class MergeSortedLinkedList {

	private Node head;
	
	public class Node{
		public Node next;
		public String element;
	}
	
	public Node add(String element) {
		Node node = new Node();
		node.next = null;
		node.element = element;
		if(head == null) {
			head = node;
		} else {
			Node first = head;
			while(first.next != null) {
				first = first.next;
			}
			first.next = node;
		}
		return head;
	}
	
	public Node addAll(String[] elements) {
		Node first = null;
		int i = elements.length;
		for(int j=0; j<i; j++) {
			first = add(elements[j]);
		}
		return first;
	}
	public Iterator<String> iterator(){
		return new Iterator<String>() {
			
			Node first = head;
			
			@Override
			public boolean hasNext() {
				return first != null;
			}

			@Override
			public String next() {
				String val = first.element;
				first = first.next;
				return val;
			}
		};
	}
	
	public Node mergeList(Node ahead, Node bhead) {
		Node abhead = null;
		Node current = null;
		while(ahead != null || bhead != null) {
			if(ahead != null && bhead != null) {
				if(ahead.element.compareTo(bhead.element) < 0 ) {
					if(abhead == null && current == null) {
						abhead = ahead;
						current = abhead;
					} else {
						current.next = ahead;
						current = current.next;
					}
					ahead = ahead.next;
				} else {
					if(abhead == null && current == null) {
						abhead = bhead;
						current = abhead;
					} else {
						current.next = bhead;
						current = current.next;
					}
					bhead = bhead.next;
				}
			} else {
				if(ahead == null && bhead != null) {
					current.next = bhead;
					bhead = bhead.next;
				} else {
					current.next = ahead;
					ahead = ahead.next;
				}
				current = current.next;
			}
		}
		return abhead;
	}
}
