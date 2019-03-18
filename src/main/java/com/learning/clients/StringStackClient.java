package com.learning.clients;

import java.util.Iterator;

import com.learning.exception.StackUnderflowException;
import com.learning.idatastructure.Stack;
import com.learning.impl.datastructure.StackArrayImpl;
import com.learning.impl.datastructure.StackListImpl;

public class StringStackClient {

	public static void main(String[] args) {
		Stack<String> stack = new StackArrayImpl<>();
		stackClientCall(stack);
		
		System.out.println("------------------------");
		System.out.println("************************");
		System.out.println("------------------------");
		
		stack = new StackListImpl<>();
		stackClientCall(stack);
	}

	private static void stackClientCall(Stack<String> stack) {
		if (stack.isEmpty()) {
			System.out.println("empty stack");
		}
		String inputs = "to be or not - to - be is the question - - - -";
		for (String input : inputs.split(" ")) {
			if (input.equalsIgnoreCase("-") && !stack.isEmpty()) {
				try {
					stack.pop();
				} catch (StackUnderflowException e) {
					System.out.println("stack underflow exception");
				}
			} else {
				stack.push(input);
			}
			System.out.println("the size of stack is: "+stack.size());
			printStack(stack);
		}
	}
	
	private static void printStack(Stack<String> stack) {
		Iterator<String> itr = stack.iterator();
		System.out.println("-----------");
		while(itr.hasNext()) {
			System.out.print(itr.next()+" ");
		}
		System.out.println();
	}
}
