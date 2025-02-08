package com.banu.prefixsum;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sum-of-variable-length-subarrays/description/?envType=problem-list-v2&envId=prefix-sum
 */
public class SubArraySum {

	public static void main(String[] args) {

		int[] nums = { 2, 3, 1 };
		int[] nums1 = { 3, 1, 1, 2 };
		System.out.println(subArraySumm(nums));
//		System.out.println(subArraySum(nums1));

	}

	private static int subArraySumm(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += getSum(nums, Math.max(0, i - nums[i]), i);
		}
		return sum;
	}

	private static int getSum(int[] nums, int start, int end) {
		int sum = 0;
		for (int i = start; i <= end; i++) {
			sum += nums[i];
		}
		return sum;
	}

//optimal solution
	private static int subArraySum(int[] nums) {
		// initial with 0 if arrays size is 1, its the sum.
		int ans = nums[0];
		// from index 1 start building presum.
		for (int i = 1; i < nums.length; i++) {
			// preserve current idx value to temp to calculate start.
			int temp = nums[i];
			// presum in same array to save space.
			nums[i] = nums[i] + nums[i - 1];
			// calculate start
			int start = Math.max(0, i - temp);
			// substract presum from value at start-1 (-1 because we start index at 1)
			ans += nums[i] - ((start == 0) ? 0 : nums[start - 1]);
		}
		return ans;
	}

}
