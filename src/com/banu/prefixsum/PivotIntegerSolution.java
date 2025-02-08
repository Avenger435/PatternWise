package com.banu.prefixsum;

import java.util.Arrays;

/*
 * 
 * https://leetcode.com/problems/find-the-pivot-integer/?envType=problem-list-v2&envId=prefix-sum
 * 
 */
public class PivotIntegerSolution {

	public static void main(String[] args) {

		System.out.println(pivotInteger(5));
	}

	/**
	 * 
	 * @param n
	 * @return
	 */
	public static int pivotInteger(int n) {
		if (n == 1) {
			return 1;
		}
		int[] arr = new int[n];

		int[] prefixSum = new int[n];
		int[] postFixSum = new int[n];
		arr[0] = 1;
		prefixSum[0] = 1;
		for (int i = 1; i < n; ++i) {
			arr[i] = arr[i - 1] + 1;
			prefixSum[i] += prefixSum[i - 1] + arr[i];
		}
		postFixSum[n - 1] = arr[arr.length - 1];
		int leftPivot = -1;
		for (int i = n - 1; i > 1; --i) {
			postFixSum[i - 1] += postFixSum[i] + arr[i - 1];
			if (postFixSum[i - 1] == prefixSum[i - 1]) {
				leftPivot = i;
			}
		}

		return leftPivot;
	}
}
