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
class InsertionSortTest {

	@Test
	void test() {
		String[] arr = { "KING", "QUEEN", "KNIGHT", "BISHOP", "ROOK" };
		InsertionSort<String> insertionSort = new InsertionSort<>();
		insertionSort.sort(arr);
		assertEquals("BISHOP", arr[0]);
		assertEquals("KING", arr[1]);
		assertEquals("KNIGHT", arr[2]);
		assertEquals("QUEEN", arr[3]);
		assertEquals("ROOK", arr[4]);
	}

}
