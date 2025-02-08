package com.banu.prefixsum;

import java.util.Arrays;

public class MaxConsecutiveOnesIII {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
		System.out.println(Arrays.toString(nums));
		int k = 2;
		int ones = findMaxConsecutiveOnes(nums, k);
		System.out.println("output: " + ones);
		if (ones == 6) {
			System.out.println("case 1 passed");
		} else {
			System.err.println("case 1 failed");
		}
//		int[] nums1 = { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 };
//		int l = 3;
//		System.out.println();
//		int ones1 = findMaxConsecutiveOnes(nums1, l);
//		System.out.println("output: " + ones1);
//		if (ones1 == 10) {
//			System.out.println("case 2 passed");
//		} else {
//			System.err.println("case 2 failed");
//		}
	}

	public static int findMaxConsecutiveOnes(int[] nums, int k) {
		int max = Integer.MIN_VALUE;
		int start = 0;
		int end = 0;
		int zeroCounter = 0;
		int zeroIndex = 0;
		int counter = 0;
		int firstZeroIndex = 0;
		while (end < nums.length) {
			System.out.println(
					"start: " + start + " end: " + end + " zeroCounter: " + zeroCounter + " counter: " + counter);
			// expand window end++;
			if (nums[end] == 1) {
				counter++;
				end++;
				max = Math.max(max, counter + zeroCounter);
			}
			if (nums[end] == 0 && zeroCounter <= k) {
				if (zeroCounter == 1)
					firstZeroIndex = end;
				if (zeroCounter == k) {
					System.out.println("zeroCounter saturated");
					start = firstZeroIndex;
					end++;
					zeroCounter--;
				} else {
					zeroCounter++;
					end++;
				}
				max = Math.max(max, counter + zeroCounter);
			}

		}

		return max;
	}

	public static int findMax(int[] nums) {
		int n = nums.length;
		int max = Integer.MIN_VALUE;
		int counter = 0;
		int currIndex = 0;
		int maxIndex = Integer.MIN_VALUE;
		int zerIndex = 0;
		for (int i = 0; i < n; ++i) {
			if (nums[i] == 1) {
				counter++;
				currIndex += i;
			} else {
				counter = 0;
				zerIndex = i;
			}
			max = Math.max(max, counter);
			maxIndex = Math.min(i, currIndex);
		}
		System.out.println(maxIndex);
		return max;
	}
}
