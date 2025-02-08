package com.banu.util;

import java.util.Arrays;
import java.util.HashSet;

public class HashSetUtil {

	public static void main(String[] args) {

		HashSet<Integer> hashSet = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4));

		System.out.println(hashSet.isEmpty());

		System.out.println(hashSet);

		if (hashSet.contains(3)) {
			System.out.println("element 3 found");
		} else {
			System.out.println("element 3 not found");
		}

		hashSet.add(5);
		hashSet.remove(2);

		System.out.println(hashSet.contains(2));

		for (int element : hashSet) {
			System.out.println(element);
		}

	}

}
