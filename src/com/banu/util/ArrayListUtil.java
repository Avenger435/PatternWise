package com.banu.util;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.SortedMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayListUtil {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>(Collections.nCopies(5, 0));

		System.out.println(list);
		System.out.println(list.size());
		// add at end
		list.add(10);
		// add at index
		list.add(2, 1);
		list.remove(4);
		System.out.println(list);
		System.out.println(list.size());
		// swap
		Collections.swap(list, 2, 5);
		System.out.println(list);
		List<Integer> emptyList = Collections.emptyList();
		System.out.println(emptyList);
		// Empty Map.
		Map emptyMap = Collections.EMPTY_MAP;
		System.out.println(emptyMap);
		// Empty Map.
		Map<Integer, Integer> emptyIntMap = Collections.emptyMap();
		System.out.println(emptyIntMap);
		// LIFO QUEUE
		Queue<Integer> asLifoQueue = Collections.asLifoQueue(new ArrayDeque<Integer>(list));
		System.out.println(asLifoQueue);
		asLifoQueue.remove();
		System.out.println(asLifoQueue);
		// checkedCollection allows only defined type class variables to be added.
		Collection<Integer> collectionInt = Collections.checkedCollection(list, Integer.class);
		System.out.println(collectionInt);

		System.out.println(list);
		Collections.copy(list, emptyList);
		System.out.println(list);
		int[] nums = { 1, 2, 3 };
		List<Integer> intList = IntStream.of(nums).boxed().collect(Collectors.toList());
		System.out.println(intList);

		boolean disjoint = Collections.disjoint(collectionInt, intList);
		System.out.println(disjoint);

		SortedMap<Object, Object> emptySortedMap = Collections.emptySortedMap();
		emptySortedMap.put(1, 1);
		emptySortedMap.put(2, 3);
		System.out.println(emptySortedMap);
	}

}
