package com.banu.prefixsum;

/**
 * https://leetcode.com/problems/make-array-elements-equal-to-zero?envType=problem-list-v2&envId=prefix-sum
 */

public class MakeArrayElementsEqualToZero {

	public static void main(String[] args) {

		int[] nums = { 1, 0, 2, 0, 3 };
//		int[] nums = { 2, 3, 4, 0, 4, 1, 0 };
//		System.out.println(Arrays.toString(nums));
		System.out.println(countValidSelections(nums));
	}

	public static int countValidSelections(int[] nums) {

		int n = nums.length;

		int[] preSum = new int[n];
		int[] postSum = new int[n];
		int selections = 0;
		for (int i = 1; i < n; ++i) {
			preSum[i] += preSum[i - 1] + nums[i - 1];
		}

		for (int i = n - 2; i >= 0; --i) {
			postSum[i] = postSum[i + 1] + nums[i + 1];
		}

		for (int i = 0; i < n; ++i) {
			if (nums[i] != 0)
				continue;
			// Both sides equal zero at the same time.
			if (preSum[i] == postSum[i]) {
				selections += 2;
			}
			// only one side equals zero at the end.
			if (Math.abs(preSum[i] - postSum[i]) == 1) {
				selections += 1;
			}
		}

//		System.out.println(Arrays.toString(preSum));
//		System.out.println(Arrays.toString(postSum));
		return selections;

	}

}
