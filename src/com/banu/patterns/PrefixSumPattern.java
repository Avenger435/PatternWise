package com.banu.patterns;

import java.util.Arrays;

public class PrefixSumPattern {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5 };

		// prefix sum including 0
		callPrefixSum(arr);

		// prefix sum from 1.

	}

	private static int callPrefixSum(int[] arr) {

		int length = arr.length;
		int[] prefixSum = new int[length];
		int[] suffixSum = new int[length];

		// calculate prefix sum => Definition being, value position is sum of previous
		// elements.
		int prefixSumVal = 0;
		for (int i = 0; i < length; i++) {
			prefixSumVal += arr[i];
			prefixSum[i] = prefixSumVal;
		}

		// SuffixSum:
		int suffixSumVal = 0;
		for (int i = length - 1; i >= 0; i--) {
			suffixSumVal += arr[i];
			suffixSum[i] = suffixSumVal;
		}
		System.out.println(Arrays.toString(prefixSum));
		System.out.println(Arrays.toString(suffixSum));
		return 0;
	}

}
