package com.learning.gfg.linkedlist;

/**
 * Algorithm to detect loop in linked list.
 * 
 * @author aadiyogis
 *
 */
public class LoopDetectionLinkedList {

	private Node head;
	private int size;

	private class Node {
		Node next;
		String element;
	}

	private Node addToLoop(String element, Node loopAt) {
		Node node = new Node();
		node.element = element;
		if (loopAt != null) {
			node.next = loopAt;
		} else {
			node.next = null;
		}
		if (head == null) {
			head = node;
		} else {
			Node first = head;
			while (first.next != null) {
				first = first.next;
			}
			first.next = node;
		}
		size++;
		return node;
	}

	public String[] iterateOnLoop() {
		return this.itertateOnLoop(size);
	}

	public String[] itertateOnLoop(int time) {
		String[] arr = new String[time];
		Node first = head;
		for (int i = 0; i < time; i++) {
			arr[i] = first.element;
			first = first.next;
		}
		return arr;
	}

	public void createLoopedLinkedList(int indexLoopToCreate, String[] elements) {
		int size = elements.length;
		if (size < indexLoopToCreate) {
			throw new IllegalArgumentException();
		} else {
			Node loopedNode = null;
			for (int i = 0; i < size - 1; i++) {
				if (i == (indexLoopToCreate - 1)) {
					loopedNode = addToLoop(elements[i], null);
				} else {
					addToLoop(elements[i], null);
				}
			}
			addToLoop(elements[size - 1], loopedNode);
		}
	}
	
	public boolean detectLoop() {
		Node slow = head;
		Node fast = head;
		
		while(slow != null && fast != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				return true;
			}
		}
		return false;
	}
}
