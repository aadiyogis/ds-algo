package com.learning.impl.datastructure;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.learning.exception.StackUnderflowException;
import com.learning.idatastructure.Stack;

class StackListImplTest {

	private Stack<String> stack;

	@BeforeEach
	void setup() {
		stack = new StackListImpl<>();
	}

	@Test
	void testPush() {
		stack.push("KING");
		stack.push("QUEEN");
		assertEquals(2, stack.size());
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
		element = stack.pop();
		element = stack.pop();
		assertEquals("KING", element);
	}

	@Test
	void testPop_throwingException() {
		assertThrows(StackUnderflowException.class, ()->{
			stack.pop();
		});
	}
	@Test
	void testIsEmpty() {
		boolean emptyness = stack.isEmpty();
		assertEquals(true, emptyness);

		stack.push("KING");
		emptyness = stack.isEmpty();
		assertEquals(false, emptyness);
	}

	@Test
	void testSize() {
		int size = stack.size();
		assertEquals(0, size);

		stack.push("KING");
		size = stack.size();
		assertEquals(1, size);
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
			arr[i++] = iterator.next();
		}
		assertEquals("BISHOP", arr[0]);
		assertEquals("KNIGHT", arr[1]);
		assertEquals("QUEEN", arr[2]);
		assertEquals("KING", arr[3]);
	}

}
