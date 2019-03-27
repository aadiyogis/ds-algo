/**
 * 
 */
package com.learning.impl.datastructure;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.learning.gfg.linkedlist.LoopDetectionLinkedList;

/**
 * @author aadiyogis
 *
 */
class LoopDetectionLinkedListTest {

	@Test
	void testLoopCreation() {
		LoopDetectionLinkedList list = new LoopDetectionLinkedList();
		String[] arr = {"KING","PAWN","ROOK","KNIGHT","BISHOP", "QUEEN"};
		list.createLoopedLinkedList(2, arr);
		
		String[] valArr = list.iterateOnLoop();
		assertEquals("KING", valArr[0]);
		assertEquals("QUEEN", valArr[5]);
		
		String[] valReArr = list.itertateOnLoop(8);
		assertEquals(8, valReArr.length);
		assertEquals("ROOK", valReArr[7]);
		System.out.println(Arrays.toString(valReArr));
		
		assertEquals(true, list.detectLoop());
	}

}
