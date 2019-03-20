package com.learning.gfg.linkedlist;

public class FindMiddleElement {

	private Node head;

	private class Node {
		Node next;
		String element;
	}

	private void add(String value) {
		Node node = new Node();
		node.element = value;
		node.next = head;
		head = node;
	}

	public void setup(FindMiddleElement fme) {
		fme.add("KING");
		fme.add("QUEEN");
		fme.add("BISHOP");
		fme.add("KNIGHT");
		fme.add("ROOK");
		fme.add("PAWN");
		fme.add("PLAYER");
		fme.add("PLAYER");
	}

	public static void main(String[] args) {
		FindMiddleElement fme = new FindMiddleElement();
		fme.setup(fme);
		fme.midElementBruteForce();
		fme.midElementOptimize();
	}

	private String midElementBruteForce() {
		Node pointer = head;
		int count = 0;
		while (pointer != null) {
			count++;
			pointer = pointer.next;
		}
		System.out.println("Size of list: " + count);
		int size = count / 2;
		System.out.println(" index is: " + size);
		pointer = head;
		for (int i = 0; i < size; i++) {
			pointer = pointer.next;
		}
		System.out.println(pointer.element);
		return pointer.element;
	}
	
	private String midElementOptimize() {
		Node slowPointer = head;
		Node fastPointer = head;
		while(fastPointer!=null && fastPointer.next!=null) {
			fastPointer = fastPointer.next.next;
			slowPointer = slowPointer.next;
		}
		System.out.println("element is: "+ slowPointer.element);
		return slowPointer.element;
	}
}
