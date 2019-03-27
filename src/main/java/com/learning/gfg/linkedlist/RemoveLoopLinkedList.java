/**
 * 
 */
package com.learning.gfg.linkedlist;

/**
 * @author aadiyogis
 *
 */
public class RemoveLoopLinkedList {

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

	public String[] iterateOnList() {
		String[] arr = new String[size*2];
		Node first = head;
		int i = 0;
		while (first != null && i<size*2) {
			arr[i++] = first.element;
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

	public void removeLoopBruteForce() {
		Node slow = head;
		Node fast = head;
		int collisionSize = 0;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			collisionSize++;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}

		Node collision = slow;
		Node first = head;
		Node[] commonList = new Node[collisionSize];
		int i = 0;
		while (first != collision) {
			commonList[i++] = first.next;
			first = first.next;
		}
		
		boolean loopDetected = false;
		Node nextNode = fast.next;
		while (!loopDetected && nextNode != collision) {
			for (int j = 0; j < i; j++) {
				if (nextNode == commonList[j]) {
					fast.next = null;
					loopDetected = true;
					break;
				}
			}
			nextNode = nextNode.next;
		}
	}
	
	/**
	 * Taken from geeks for geeks
	 * https://www.youtube.com/watch?v=_BG9rjkAXj8
	 */
	public void removeLoopOptimized() {
		Node slow = head;
		Node fast = head;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}
		Node first = head;
		while(first.next != fast.next) {
			first = first.next;
			fast = fast.next;
		}
		fast.next = null;
	}
}
