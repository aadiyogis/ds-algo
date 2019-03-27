/**
 * 
 */
package com.learning.impl.datastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.learning.gfg.linkedlist.RemoveLoopLinkedList;

/**
 * @author aadiyogis
 *
 */
class RemoveLoopLinkedListTest {

	@Test
	void test() {
		RemoveLoopLinkedList list = new RemoveLoopLinkedList();
		String[] arr = {"KING","PAWN","ROOK","KNIGHT","BISHOP", "QUEEN"};
		list.createLoopedLinkedList(2, arr);
		
		String[] valArr = list.iterateOnLoop();
		assertEquals("KING", valArr[0]);
		assertEquals("QUEEN", valArr[5]);
		
		String[] valReArr = list.itertateOnLoop(8);
		assertEquals(8, valReArr.length);
		assertEquals("ROOK", valReArr[7]);
		System.out.println(Arrays.toString(valReArr));
		
		list.removeLoopBruteForce();
		String[] listIter = list.iterateOnList();
		assertEquals(null, listIter[7]);
		assertEquals("QUEEN", listIter[5]);
		System.out.println(Arrays.toString(listIter));
		
		RemoveLoopLinkedList list2 = new RemoveLoopLinkedList();
		list2.createLoopedLinkedList(2, arr);
		
		list2.removeLoopOptimized();
		String[] listIter2 = list2.iterateOnList();
		System.out.println(Arrays.toString(listIter2));
	}

}
