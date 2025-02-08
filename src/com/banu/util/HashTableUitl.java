package com.banu.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class HashTableUitl {

	public static void main(String[] args) {

		HashMap<Integer, Integer> hashMap = new HashMap<>();

		hashMap.put(1, 1);
		hashMap.put(2, 1);
		hashMap.put(3, 1);
		hashMap.put(4, 1);
		hashMap.put(5, 1);
		System.out.println(hashMap);
		System.out.println(hashMap.isEmpty());

		if (hashMap.containsKey(1)) {
			System.out.println(hashMap.get(1));
		} else {
			System.out.println("key 1 not found");
		}

		System.out.println(hashMap.get(21));

		System.out.println(hashMap.getOrDefault(33, -1));
		hashMap.remove(4);
		System.out.println(hashMap);

		hashMap.compute(2, (a, b) -> b + 1);
		System.out.println(hashMap);
		Map<Integer, Collection<Integer>> newMap = new HashMap();
//		newMap.computeIfAbsent(10, new HashSet<>().add(2));
		newMap.computeIfAbsent(10, k -> new HashSet<Integer>()).addAll(Arrays.asList(1, 2, 3));
		System.out.println(newMap);
		System.out.println(hashMap);
		hashMap.computeIfPresent(10, (a, b) -> b % 10);
		System.out.println(hashMap);

		hashMap.forEach((k, v) -> System.err.println(k));
	}

}
