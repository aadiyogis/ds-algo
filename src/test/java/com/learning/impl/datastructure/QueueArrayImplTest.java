/**
 * 
 */
package com.learning.impl.datastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.learning.idatastructure.Queue;

/**
 * @author aadiyogis
 *
 */
class QueueArrayImplTest {

	private Queue<String> queue;

	@BeforeEach
	private void setup() {
		queue = new QueueArrayImpl<>();
	}

	@Test
	void testIsEmpty() {
		assertEquals(true, queue.isEmpty());
		queue.enque("KING");
		assertEquals(false, queue.isEmpty());
		queue.dequeue();
		assertEquals(true, queue.isEmpty());
	}

	@Test
	void testSize() {
		assertEquals(0, queue.size());
		queue.enque("KING");
		assertEquals(1, queue.size());
		queue.dequeue();
		assertEquals(0, queue.size());
	}

	@Test
	void testEnque() {
		queue.enque("KING");
		queue.enque("QUEEN");
		queue.enque("ROOK");
		queue.enque("KNIGHT");
		queue.enque("BISHOP");

		String[] arr = new String[5];
		int i = 0;
		Iterator<String> iterator = queue.iterator();
		while (iterator.hasNext()) {
			arr[i++] = iterator.next();
		}

		assertEquals("KING", arr[0]);
		assertEquals("QUEEN", arr[1]);
		assertEquals("ROOK", arr[2]);
		assertEquals("KNIGHT", arr[3]);
		assertEquals("BISHOP", arr[4]);

	}

	@Test
	void testDequeue() {
		queue.enque("KING");
		queue.enque("QUEEN");
		queue.enque("ROOK");
		queue.enque("KNIGHT");
		queue.enque("BISHOP");

		String val = queue.dequeue();
		assertEquals("KING", val);

		val = queue.dequeue();
		assertEquals("QUEEN", val);
	}
}
