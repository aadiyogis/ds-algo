/**
 * 
 */
package com.learning.impl.datastructure;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

import com.learning.gfg.linkedlist.PairwiseSwapLinkedList;

/**
 * @author aadiyogis
 *
 */
class PairwiseSwapLinkedListTest {

	@Test
	void test() {
		PairwiseSwapLinkedList list = new PairwiseSwapLinkedList();
		String[] arr = {"KING", "QUEEN", "BISHOP", "ROOK", "KNIGHT", "PAWN"};
		list.addAll(arr);
		
		list.pairwiseswap();
		
		String[] swaparr = new String[6];
		swaparr = convertToArr(list, swaparr);
		assertEquals("QUEEN", swaparr[0]);
		assertEquals("KING", swaparr[1]);
	}
	
	private String[] convertToArr(PairwiseSwapLinkedList list, String[] swaparr) {
		int i = 0;
		String[] swarr = new String[swaparr.length];
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {
			swarr[i++] = iterator.next();
		}
		return swarr;
	}

}
