package com.banu.leet;

/**
 * https://leetcode.com/problems/max-consecutive-ones/
 */
public class MaxConsecutiveOnes {

	public static void main(String[] args) {

		int[] nums = { 1, 1, 0, 1, 1, 1 };

		int output = findMaxConsecutiveOnes(nums);
		if (output == 3) {
			System.out.println("passed");
		} else {
			System.err.println("failed");
		}

	}

	public static int findMaxConsecutiveOnes(int[] nums) {
		int n = nums.length;
		int max = Integer.MIN_VALUE;
		int counter = 0;
		for (int i = 0; i < n; ++i) {
			if (nums[i] == 1) {
				counter++;
			} else {
				counter = 0;
			}
			max = Math.max(max, counter);
		}
		return max;
	}

}
