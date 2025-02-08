package com.banu.prefixsum;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 
 * https://leetcode.com/problems/sum-of-all-odd-length-subarrays/?envType=problem-list-v2&envId=prefix-sum
 * 
 */
public class SumOddLengthSubArrays {

	public static void main(String[] args) {

//		System.out.println("case1: " + sumOddLengthSubarrays(new int[] { 1, 4, 2, 5, 3 }));
//		System.out.println("case1: " + sumOddLengthSubarrays(new int[] { 1, 2 }));
		System.out.println("case1: " + sumOddLengthSubarray(new int[] { 1, 4, 2, 5, 3 }));
		System.out.println("case1: " + sumOddLengthSubarray(new int[] { 1, 2 }));

	}

	// optimal solution:
	private static int sumOddLengthSubarray(int[] arr) {
		int sum = 0;
		int n = arr.length;

		for (int i = 0; i < n; i++) {
			int left = i + 1;
			int right = n - i;
			int total = left * right;
			int odd = (total + 1) / 2;
			sum += arr[i] * odd;
		}

		return sum;
	}

	// solution:
	public static int sumOddLengthSubarrays(int[] arr) {
		int oddSum = 0;
		int n = arr.length;
		for (int i = 0; i <= n; ++i) {
			if ((i) % 2 != 0)
				oddSum += getSum(arr, i);
		}
		return oddSum;
	}

	private static int getSum(int[] arr, int i) {
		List<Integer> list = IntStream.of(arr).mapToObj(k -> (int) k).toList();
		int sum = 0;
		int startIndex = 0;
		int endIndex = startIndex + i;
		while (endIndex <= list.size()) {
			System.out.println(list.subList(startIndex, endIndex));
			sum += list.subList(startIndex, endIndex).stream().collect(Collectors.summingInt(Integer::intValue));
			endIndex++;
			startIndex++;
		}
		return sum;
	}
}
