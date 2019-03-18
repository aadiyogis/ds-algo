package com.learning.impl.datastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.learning.exception.StackUnderflowException;
import com.learning.idatastructure.Stack;

class StackArrayImplTest {

	private Stack<String> stack;

	@BeforeEach
	void setup() {
		stack = new StackArrayImpl<>();
	}

	@Test
	void testPush() {
		stack.push("KING");
		stack.push("QUEEN");
		stack.push("KNIGHT");
		stack.push("BISHOP");
		assertEquals(4, stack.size());
	}

	@Test
	void testPop() throws StackUnderflowException {
		stack.push("KING");
		stack.push("QUEEN");
		stack.push("KNIGHT");
		stack.push("BISHOP");
		String element = stack.pop();
		assertEquals("BISHOP", element);
		element = stack.pop();
		assertEquals("KNIGHT", element);
		element = stack.pop();
		assertEquals("QUEEN", element);
	}

	@Test
	void testIsEmpty() throws StackUnderflowException {
		boolean emptyness = stack.isEmpty();
		assertEquals(true, emptyness);

		stack.push("KING");
		emptyness = stack.isEmpty();
		assertEquals(false, emptyness);

		stack.pop();
		emptyness = stack.isEmpty();
		assertEquals(true, emptyness);
	}

	@Test
	void testSize() throws StackUnderflowException {
		int size = stack.size();
		assertEquals(0, size);

		stack.push("KING");
		size = stack.size();
		assertEquals(1, size);

		stack.pop();
		size = stack.size();
		assertEquals(0, size);
	}

	@Test
	void testIterator() {
		stack.push("KING");
		stack.push("QUEEN");
		stack.push("KNIGHT");
		stack.push("BISHOP");
		Iterator<String> iterator = stack.iterator();
		String[] arr = new String[4];
		int i = 0;
		while (iterator.hasNext()) {
			arr[i] = iterator.next();
			i++;
		}
		assertEquals("BISHOP", arr[0]);
		assertEquals("KNIGHT", arr[1]);
		assertEquals("QUEEN", arr[2]);
		assertEquals("KING", arr[3]);
	}

}
