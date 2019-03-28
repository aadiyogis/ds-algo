/**
 * 
 */
package com.learning.impl.datastructure;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.learning.gfg.linkedlist.MergeSortedLinkedList;
import com.learning.gfg.linkedlist.MergeSortedLinkedList.Node;

/**
 * @author aadiyogis
 *
 */
class MergeSortedLinkedListTest {

	@Test
	void testAListBigThanBList() {
		MergeSortedLinkedList alist = new MergeSortedLinkedList();
		String[] aelements = {"KING", "PAWN", "QUEEN", "ROOK"};
		Node ahead = alist.addAll(aelements);
		
		MergeSortedLinkedList blist = new MergeSortedLinkedList();
		String[] belements = {"BISHOP", "KNIGHT"};
		Node bhead = blist.addAll(belements);
		
		Node abhead = alist.mergeList(ahead, bhead);
		checkValidity(abhead);
	}

	@Test
	void testAListEqualSizeToBList() {
		MergeSortedLinkedList alist = new MergeSortedLinkedList();
		String[] aelements = {"KING", "PAWN", "QUEEN"};
		Node ahead = alist.addAll(aelements);
		
		MergeSortedLinkedList blist = new MergeSortedLinkedList();
		String[] belements = {"BISHOP", "KNIGHT", "ROOK"};
		Node bhead = blist.addAll(belements);
		
		Node abhead = alist.mergeList(ahead, bhead);
		checkValidity(abhead);
	}
	
	@Test
	void testAListSmallThanBList() {
		MergeSortedLinkedList alist = new MergeSortedLinkedList();
		String[] aelements = {"KING", "QUEEN"};
		Node ahead = alist.addAll(aelements);
		
		MergeSortedLinkedList blist = new MergeSortedLinkedList();
		String[] belements = {"BISHOP", "KNIGHT", "PAWN", "ROOK"};
		Node bhead = blist.addAll(belements);

		Node abhead = alist.mergeList(ahead, bhead);
		checkValidity(abhead);
	}
	private void checkValidity(Node abhead) {
		String[] abelements = new String[6];
		int i = 0;
		while(abhead != null) {
			abelements[i++] = abhead.element;
			abhead = abhead.next;
		}
		
		assertEquals("BISHOP", abelements[0]);
		assertEquals("KING", abelements[1]);
		assertEquals("KNIGHT", abelements[2]);
		assertEquals("PAWN", abelements[3]);
		assertEquals("QUEEN", abelements[4]);
		assertEquals("ROOK", abelements[5]);
	}

}
