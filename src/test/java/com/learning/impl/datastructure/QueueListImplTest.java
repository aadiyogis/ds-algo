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
class QueueListImplTest {

	private Queue<String> queue;
	
	@BeforeEach
	private void setup() {
		queue = new QueueListImpl<>();
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
	void testIsEmpty() {
		assertEquals(true, queue.isEmpty());
		queue.enque("KING");
		assertEquals(false, queue.isEmpty());
		queue.dequeue();
		assertEquals(true, queue.isEmpty());
	}
	
	@Test
	void testEnqueue() {
		queue.enque("KING");
		queue.enque("QUEEN");
		queue.enque("KNIGHT");
		queue.enque("ROOK");
		queue.enque("BISHOP");
		
		String[] arr = new String[5];
		extractToArray(arr);
		
		assertEquals("KING", arr[0]);
		assertEquals("QUEEN", arr[1]);
		assertEquals("KNIGHT", arr[2]);
		assertEquals("ROOK", arr[3]);
		assertEquals("BISHOP", arr[4]);
	}

	private void extractToArray(String[] arr) {
		Iterator<String> iterator = queue.iterator();
		int i = 0;
		while(iterator.hasNext()) {
			arr[i++] = iterator.next();
		}
	}
	
	@Test
	void testDequeue() {
		queue.enque("KING");
		queue.enque("QUEEN");
		queue.enque("KNIGHT");
		queue.enque("ROOK");
		queue.enque("BISHOP");
		
		String val = queue.dequeue();
		assertEquals("KING", val);
		
		val = queue.dequeue();
		assertEquals("QUEEN", val);
		
		String[] arr = new String[3];
		extractToArray(arr);
		assertEquals("KNIGHT", arr[0]);
		assertEquals("ROOK", arr[1]);
		assertEquals("BISHOP", arr[2]);
		
	}
}
