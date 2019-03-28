package com.learning.impl.datastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.learning.idatastructure.List;

class LinkedListImplTest {

	private List<String> stringList;

	@BeforeEach
	void setup() {
		stringList = new LinkedListImpl<>();
	}

	@Test
	void testAdd() {
		stringList.add("KING");
		stringList.add("QUEEN");
		stringList.add("KNIGHT");
		stringList.add("BISHOP");

		String[] arr = new String[4];
		extractToArray(arr);
		assertEquals("KING", arr[3]);
		assertEquals("QUEEN", arr[2]);
		assertEquals("KNIGHT", arr[1]);
		assertEquals("BISHOP", arr[0]);
		
	}

	@Test
	void testRemove_fromStartOfList() {
		stringList.add("KING");
		stringList.add("QUEEN");
		stringList.add("KNIGHT");
		stringList.add("BISHOP");
		
		String element = stringList.remove("BISHOP");
		assertEquals("BISHOP", element);
		
		String[] arr = new String[4];
		extractToArray(arr);
		
		assertEquals("KING", arr[2]);
		assertEquals("QUEEN", arr[1]);
		assertEquals("KNIGHT", arr[0]);
	}

	@Test
	void testRemove_fromMiddleOfList() {
		stringList.add("KING");
		stringList.add("QUEEN");
		stringList.add("PAWN");
		stringList.add("KNIGHT");
		stringList.add("BISHOP");
		
		String element = stringList.remove("PAWN");
		assertEquals("PAWN", element);
		
		String[] arr = new String[4];
		extractToArray(arr);
		assertEquals("KING", arr[3]);
		assertEquals("QUEEN", arr[2]);
		assertEquals("KNIGHT", arr[1]);
		assertEquals("BISHOP", arr[0]);
	}
	
	@Test
	void testRemove_fromEndOfList() {
		stringList.add("KING");
		stringList.add("QUEEN");
		stringList.add("KNIGHT");
		stringList.add("BISHOP");
		
		String element = stringList.remove("KING");
		assertEquals("KING", element);
		
		String[] arr = new String[4];
		extractToArray(arr);
		assertEquals("QUEEN", arr[2]);
		assertEquals("KNIGHT", arr[1]);
		assertEquals("BISHOP", arr[0]);
	}
	
	@Test
	void testIsEmpty() {
		assertEquals(true, stringList.isEmpty());
		stringList.add("KING");
		assertEquals(false, stringList.isEmpty());
		stringList.remove("KING");
		assertEquals(true, stringList.isEmpty());
	}

	@Test
	void testGetSize() {
		assertEquals(0, stringList.getSize());
		stringList.add("KING");
		assertEquals(1, stringList.getSize());
		stringList.remove("KING");
		assertEquals(0, stringList.getSize());
	}

	@Test
	void testIterator() {
		stringList.add("KING");
		stringList.add("QUEEN");
		stringList.add("KNIGHT");
		stringList.add("BISHOP");

		String[] arr = new String[4];
		extractToArray(arr);
		assertEquals("KING", arr[3]);
		assertEquals("QUEEN", arr[2]);
		assertEquals("KNIGHT", arr[1]);
		assertEquals("BISHOP", arr[0]);
	}

	private void extractToArray(String[] arr) {
		Iterator<String> listIterator = stringList.iterator();
		int i = 0;
		while (listIterator.hasNext()) {
			arr[i] = listIterator.next();
			i++;
		}
	}
}
