/**
 * 
 */
package com.learning.algorithm;

/**
 * @author aadiyogis
 *
 */
public class SelectionSort<T extends Comparable<T>> implements Sort<T> {

	@Override
	public void sort(Comparable<T>[] arr) {
		int length = arr.length;
		for (int i = 0; i < length; i++) {
			int min = i;
			for (int j = i + 1; j < length; j++) {
				if (less(arr[j], arr[min])) {
					min = j;
				}
			}
			swap(arr, i, min);
		}
	}

}
