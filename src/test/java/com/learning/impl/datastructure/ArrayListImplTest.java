package com.learning.impl.datastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.learning.idatastructure.List;

class ArrayListImplTest {

	private List<String> stringList;
	@BeforeEach
	void setup() {
		stringList = new ArrayListImpl<>();
	}
	
	@Test
	void testAdd() {
		stringList.add("KING");
		stringList.add("QUEEN");
		stringList.add("KNIGHT");
		stringList.add("BISHOP");
		
		assertEquals(4,stringList.getSize());
	}

	@Test
	void testRemove() {
		stringList.add("KING");
		stringList.add("QUEEN");
		stringList.add("KNIGHT");
		stringList.add("BISHOP");
		
		String val = stringList.remove("KNIGHT");
		assertEquals("KNIGHT", val);
		String[] arr = new String[4];
		extractToArray(arr);
		
		assertEquals("KING",arr[0]);
		assertEquals("QUEEN",arr[1]);
		assertEquals("BISHOP",arr[2]);
		
	}

	@Test
	void testIsEmpty() {
		boolean emptyness = stringList.isEmpty();
		assertEquals(true, emptyness);
		
		stringList.add("KING");
		emptyness = stringList.isEmpty();
		assertEquals(false, emptyness);
		
		stringList.remove("KING");
		emptyness = stringList.isEmpty();
		assertEquals(true, emptyness);
	}

	@Test
	void testGetSize() {
		int size = stringList.getSize();
		assertEquals(0, size);
		
		stringList.add("KING");
		size = stringList.getSize();
		assertEquals(1, size);
		
		stringList.remove("KING");
		size = stringList.getSize();
		assertEquals(0, size);
	}

	@Test
	void testIterator() {
		stringList.add("KING");
		stringList.add("QUEEN");
		stringList.add("KNIGHT");
		stringList.add("BISHOP");
		String[] arr = new String[4];
		extractToArray(arr);
		assertEquals("KING",arr[0]);
		assertEquals("QUEEN",arr[1]);
		assertEquals("KNIGHT",arr[2]);
		assertEquals("BISHOP",arr[3]);
	}

	private void extractToArray(String[] arr) {
		Iterator<String> iterator  = stringList.iterator();
		int i = 0;
		while(iterator.hasNext()) {
			arr[i] = iterator.next();
			i++;
		}
	}

}
