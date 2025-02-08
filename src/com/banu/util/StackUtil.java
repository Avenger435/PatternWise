package com.banu.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Stack;

public class StackUtil {

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<>();
		Collection<Integer> coll = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
		stack.push(12);
		stack.push(13);
		stack.push(14);

		System.out.println(stack.isEmpty());
		System.out.println(stack);

		stack.addAll(coll);
		System.out.println(stack);
		System.out.println(stack.peek());
		stack.pop();
		System.out.println(stack);
		System.out.println(stack.peek());
	}

}
