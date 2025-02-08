package com.banu.util;

import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListUtil {

	public static void main(String[] args) {

		LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
		System.out.println(list);

		System.out.println(list.isEmpty());

		list.add(1);
		System.out.println(list);
		list.addFirst(12);
		list.addLast(23);
		list.add(3, 5);

		System.out.println(list);

		list.remove();// removes first

		System.out.println(list);
		list.remove(list.size() - 1);
		System.out.println(list);

		for (int val : list)
			System.out.println(val);
	}

}
