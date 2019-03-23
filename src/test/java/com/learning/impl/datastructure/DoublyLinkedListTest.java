package com.learning.impl.datastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DoublyLinkedListTest {

	private DoublyLinkedList<String> list;
	
	@BeforeEach
	void setup() {
		list = new DoublyLinkedList<>();
	}
	
	@Test
	void testGetSize() {
		int size=list.getSize();
		assertEquals(0, size);
		
		list.add("KING");
		size = list.getSize();
		assertEquals(1, size);
		
		list.remove("KING");
		size = list.getSize();
		assertEquals(0, size);
	}

	@Test
	void testIsEmpty() {
		assertEquals(true, list.isEmpty());
		list.add("KING");
		assertEquals(false, list.isEmpty());
		list.remove("KING");
		assertEquals(true, list.isEmpty());
	}
	
	@Test
	void testadd() {
		list.add("KING");
		list.add("QUEEN");
		list.add("KNIGHT");
		list.add("BISHOP");
		list.add("ROOK");
		
		String[] arr = new String[5];
		extractToArray(arr);
		assertEquals("ROOK", arr[0]);
		assertEquals("BISHOP", arr[1]);
		assertEquals("KNIGHT", arr[2]);
		assertEquals("QUEEN", arr[3]);
		assertEquals("KING", arr[4]);
	}

	@Test
	void testGetI() {
		list.add("KING");
		list.add("QUEEN");
		list.add("KNIGHT");
		list.add("BISHOP");
		list.add("ROOK");
		
		String val = list.get(0);
		assertEquals("ROOK", val);
		
		val = list.get(2);
		assertEquals("KNIGHT", val);
		
		val = list.get(4);
		assertEquals("KING", val);
	}
	
	@Test
	void testRemove() {
		list.add("KING");
		list.add("QUEEN");
		list.add("KNIGHT");
		list.add("BISHOP");
		list.add("ROOK");
		
		String val = list.remove("ROOK");
		assertEquals("ROOK", val);
		
//		?val = list.remove("KNIGHT");
		
//		val = list.remove("KING");
	}
	
	private void extractToArray(String[] arr) {
		int i = 0;
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {
			arr[i++] = iterator.next();
		}
	}
}
