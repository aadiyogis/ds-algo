package com.learning.gfg.linkedlist;

/**
 * 
 * @author aadiyogis
 *
 */
public class ReverseLinkedList {

	private Node head;

	private class Node {
		Node next;
		String element;
	}

	private void add(String element) {
		Node node = new Node();
		node.element = element;
		node.next = null;
		if (head == null) {
			head = node;
		} else {
			Node pointer = head;
			while (pointer.next != null) {
				pointer = pointer.next;
			}
			pointer.next = node;
		}
	}

	private void setup(ReverseLinkedList rll) {
		rll.add("KING");
		rll.add("QUEEN");
		rll.add("BISHOP");
		rll.add("KNIGHT");
		rll.add("ROOK");
		rll.add("PLAYER");
		rll.add("GAME");
	}

	/**
	 * This take O(n) extra space and O(n) time complexity for reversing the linked
	 * list
	 * 
	 * @return
	 */
	private Node reverseBruteForce() {
		Node reverseHead = null;
		Node pointer = head;
		while (pointer != null) {
			Node reverseNode = new Node();
			reverseNode.element = pointer.element;
			reverseNode.next = reverseHead;
			reverseHead = reverseNode;
			pointer = pointer.next;
		}
		return reverseHead;
	}

	/**
	 * In place reversal of list using constant extra space with O(n) complexity
	 * 
	 * @return
	 */
	private Node reverseNodeOptimized() {
		Node reverseHead = null;
		Node tempNode = null;
		Node oldPointer = null;
		Node pointer = head;
		while (pointer != null) {
			tempNode = pointer.next;
			pointer.next = oldPointer;
			oldPointer = pointer;
			pointer = tempNode;
		}
		reverseHead = oldPointer;
		return reverseHead;
	}

	private void printLinkedList(Node list) {
		while (list != null) {
			System.out.println(list.element);
			list = list.next;
		}
	}

	public static void main(String[] args) {
		ReverseLinkedList rll = new ReverseLinkedList();
		rll.setup(rll);
		rll.printLinkedList(rll.head);
		System.out.println("..............printing list in reverse brute force............");
		Node reverseHead = rll.reverseBruteForce();
		rll.printLinkedList(reverseHead);

		System.out.println("..............printing list in reverse optimized way..........");
		Node reverseOptimizedWay = rll.reverseNodeOptimized();
		rll.printLinkedList(reverseOptimizedWay);

	}
}
