 /**
 * 
 */
package com.learning.algorithm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author aadiyogis
 *
 */
class SelectionSortTest {

	@Test
	void test() {
		String[] arr = {"KING", "QUEEN", "KNIGHT", "BISHOP", "ROOK"};
		SelectionSort<String> selectionSort = new SelectionSort<>();
		selectionSort.sort(arr);
		assertEquals("BISHOP", arr[0]);
		assertEquals("KING", arr[1]);
		assertEquals("KNIGHT", arr[2]);
		assertEquals("QUEEN", arr[3]);
		assertEquals("ROOK", arr[4]);
	}

}
