package com.banu.prefixsum;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/left-and-right-sum-differences/description/?envType=problem-list-v2&envId=prefix-sum
 */
public class LeftRightDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		System.out.println("sol1: " + Arrays.toString(leftRightDifference(new int[] { 10, 4, 8, 3 })));
//		System.out.println("sol2: " + Arrays.toString(leftRightDifference(new int[] { 1 })));

		System.out.println("sol1: " + Arrays.toString(diffSum(new int[] { 10, 4, 8, 3 })));
//		System.out.println("sol2: " + Arrays.toString(differenceSum(new int[] { 1 })));

	}

	public static int[] diffSum(int[] nums) {
		int n = nums.length;
		int leftSum = 0;
		int rightSum = 0;
		for (int i : nums)
			rightSum += i;
		for (int i = 0; i < n; i++) {
			int pre = nums[i];
			rightSum -= nums[i];
			nums[i] = Math.abs(leftSum - rightSum);
			leftSum += pre;
		}

		return nums;
	}

	// Optimal Solution - : 3ms
	public static int[] differenceSum(int[] nums) {
		int n = nums.length;
		int[] res = new int[nums.length];
		int[] leftSum = new int[nums.length];
		int[] suffixSum = new int[nums.length];
		leftSum[0] = 0;
		suffixSum[n - 1] = 0;
		for (int i = 1; i <= nums.length - 1; i++) {
			leftSum[i] += leftSum[i - 1] + nums[i - 1];
		}
		for (int i = n - 2; i >= 0; --i) {
			suffixSum[i] += suffixSum[i + 1] + nums[i + 1];
			res[i] = Math.abs(suffixSum[i] - leftSum[i]);
		}
		res[n - 1] = leftSum[n - 1];
//		System.out.println("leftSum: " + Arrays.toString(leftSum));
//		System.out.println("right: " + Arrays.toString(suffixSum));
//		System.out.println("res: " + Arrays.toString(res));
		return res;

	}

	// Solution 1
	public static int[] leftRightDifference(int[] nums) {
		int[] res = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			res[i] = getDiff(nums, i);
		}
		return res;
	}

	private static int getDiff(int[] nums, int start) {
		int leftSum = 0;
		int rightSum = 0;
		for (int i = 0; i <= start; i++) {
			leftSum += nums[i];
		}
		for (int i = start; i <= nums.length - 1; i++) {
			rightSum += nums[i];
		}

		return Math.abs(leftSum - rightSum);

	}

}
