/**
 * 
 */
package com.learning.impl.datastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.learning.gfg.linkedlist.NnodeFromEndLinkedList;

/**
 * @author aadiyogis
 *
 */
class NnodeFromEndLinkedListTest {

	@Test
	void test() {
		NnodeFromEndLinkedList list = new NnodeFromEndLinkedList();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.add("6");
		list.add("7");
		list.add("8");
		list.add("9");
		list.add("0");
		
		assertEquals("9", list.findNthElementFromEndBruteForce(2));
		assertEquals("2", list.findNthElementFromEndBruteForce(9));
		
		assertEquals("9", list.findNthElementFromEndOptimized(2));
		assertEquals("2", list.findNthElementFromEndOptimized(9));
		assertEquals("0", list.findNthElementFromEndOptimized(1));
	}

}
