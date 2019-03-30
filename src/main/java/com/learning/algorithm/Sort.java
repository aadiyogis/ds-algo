/**
 * 
 */
package com.learning.algorithm;

/**
 * @author aadiyogis
 *
 */
public interface Sort<T extends Comparable<T>> {
	
	public void sort(Comparable<T>[] arr);
	
	public default boolean less(Comparable<T> arr, Comparable<T> arr2) {
		return arr.compareTo((T) arr2)<0;
	}
	
	public default void swap(Comparable<T>[] arr, int i, int j) {
		Comparable<T> val = arr[i];
		arr[i] = arr[j];
		arr[j] = val;
	}
	
	public default boolean isSorted(Comparable<T>[] arr) {
		int length = arr.length;
		for(int i = 0; i < length; i++) {
			if(!less(arr[i], arr[i+1])) {
				return false;
			}
		}
		return true;
	}
}
