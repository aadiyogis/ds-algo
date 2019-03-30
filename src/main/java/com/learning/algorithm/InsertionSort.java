/**
 * 
 */
package com.learning.algorithm;

/**
 * @author aadiyogis
 * @param <T>
 *
 */
public class InsertionSort<T extends Comparable<T>> implements Sort<T> {

	@Override
	public void sort(Comparable<T>[] arr) {
		int length = arr.length;
		for (int i = 1; i < length; i++) {
			for (int j=i-1; j>-1; j--) {
				if(less(arr[j], arr[i])) {
					swap(arr, i, j);
				} else {
					break;
				}
			}
		}
	}

}
