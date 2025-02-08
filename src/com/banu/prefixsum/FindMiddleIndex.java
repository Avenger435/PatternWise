package com.banu.prefixsum;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-the-middle-index-in-array/?envType=problem-list-v2&envId=prefix-sum
 */
public class FindMiddleIndex {

	public static void main(String[] args) {

		int[] nums = { 2, 3, -1, 8, 4 };
//		int[] nums = { 1, -1, 4 };
//		int[] nums = { 1 };
//		int[] nums = {0};
//		int[] nums = {};
		System.out.println(Arrays.toString(nums));
		System.out.println(findMiddleIndex(nums));

	}

	public static int findMiddleIndex(int[] nums) {

		int n = nums.length;

		if (n == 0) {
			return -1;
		}

		int index = -1;
		int[] prefixSum = new int[n];
		int[] suffixSum = new int[n];

		prefixSum[0] = nums[0];
		suffixSum[n - 1] = nums[n - 1];
		for (int i = 1; i < n; ++i) {
			prefixSum[i] += prefixSum[i - 1] + nums[i];
		}

		for (int i = n - 2; i >= 0; --i) {
			suffixSum[i] += suffixSum[i + 1] + nums[i];
			if (suffixSum[i + 1] == prefixSum[i + 1]) {
				index = i + 1;
			}
		}
		if (prefixSum[0] == suffixSum[0]) {
			return 0;
		}

//		System.err.println("index " + index);
//
//		System.out.println("prefixSum: " + Arrays.toString(prefixSum));
//		System.out.println("suffixSum: " + Arrays.toString(suffixSum));

		return index;
	}

}
