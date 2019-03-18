package com.learning.clients;

import java.util.Iterator;

import com.learning.idatastructure.List;
import com.learning.impl.datastructure.ArrayListImpl;

public class StringListClient {

	public static void main(String[] args) {
		List<String> stringList = new ArrayListImpl<>();
		operations(stringList);
	}

	private static void operations(List<String> list) {
		boolean emptyness = list.isEmpty();
		if(emptyness) {
			System.out.println("LONELY... MR. LONELY");
		}
		list.add("A");
		list.add("B");
		list.add("C");
		int size = list.getSize();
		System.out.println(size);
		iterateList(list);
		String val = list.remove("B");
		System.out.println("val is: "+val);
		iterateList(list);
		
	}

	private static void iterateList(List<String> list) {
		System.out.println("Iterating list");
		Iterator<String> listIterator = list.iterator();
		while(listIterator.hasNext()) {
			System.out.println(listIterator.next());
		}
	}
}
