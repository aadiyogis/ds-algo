package com.learning.gfg.linkedlist;

public class RotateLinkedList {

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

	private void setup(RotateLinkedList rll) {
		rll.add("KING");
		rll.add("QUEEN");
		rll.add("KNIGHT");
		rll.add("BISHOP");
		rll.add("ROOK");
		rll.add("PLAYER");
		rll.add("GAME");
		rll.add("POINTS");
		rll.add("PAWN");
		rll.add("SET");
	}

	private Node rotate(int rotation) {
		Node rotated = null;
		Node oldPointer = head;
		Node current = head;
		Node old = null;
		while(rotation>0) {
			rotation--;
			old = current;
			current = current.next;
		}
		rotated = current;
		while(current.next!=null) {
			current = current.next; 
		}
		old.next = null;
		current.next = oldPointer;
		return rotated;
		
	}
	
	public static void main(String[] args) {
		RotateLinkedList rll = new RotateLinkedList();
		rll.setup(rll);
		System.out.println("................Original list...................");
		rll.print(rll.head);
		
		System.out.println("................After rotation by 2...................");
		Node newHead = rll.rotate(2);
		rll.print(newHead);
		
	}
	
	private void print(Node pointer) {
		while(pointer !=null) {
			System.out.println(pointer.element);
			pointer = pointer.next;
		}
	}
}
