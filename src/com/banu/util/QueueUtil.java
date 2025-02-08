package com.banu.util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class QueueUtil {

	public static void main(String[] args) {

		Queue<Integer> queue = new LinkedList<>(Arrays.asList(1, 2, 3, 4));
		System.out.println(queue.isEmpty());

		queue.add(12);
		queue.offer(121);
		System.out.println(queue);

		System.out.println(queue.peek());
		queue.poll();
		System.out.println(queue);
		System.out.println(queue.peek());
	}

}
