package com.banu.prefixsum;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/running-sum-of-1d-array/submissions/1529863499/?envType=problem-list-v2&envId=prefix-sum
 */
public class RunningSumOneDArray {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3, 4 };
		int[] nums1 = { 1, 1, 1, 1 };
		int[] nums2 = { 3, 1, 2, 10, 1 };
		int[] nums3 = {};

		System.out.println(Arrays.toString(runningSum(nums)));
		System.out.println(Arrays.toString(runningSum(nums1)));
		System.out.println(Arrays.toString(runningSum(nums2)));
		System.out.println(Arrays.toString(runningSum(nums3)));
	}

	public static int[] runningSum(int[] nums) {

		int[] pre = new int[nums.length];
		if (nums.length > 0)
			pre[0] = nums[0];
		for (int i = 1; i < nums.length; ++i) {
			pre[i] = pre[i - 1] + nums[i];
		}

		return pre;
	}

}
