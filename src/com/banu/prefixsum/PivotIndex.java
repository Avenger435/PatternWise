package com.banu.prefixsum;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-pivot-index/description/?envType=problem-list-v2&envId=prefix-sum
 */
public class PivotIndex {

	public static void main(String[] args) {
		int[] nums1 = new int[] { 1, 7, 3, 6, 5, 6 };
		System.out.println("nums1: " + Arrays.toString(nums1));
		System.out.println("case 1: " + getPivotIndex(nums1));
		System.out.println();
		int[] nums2 = new int[] { 1, 2, 3 };
		System.out.println("nums2: " + Arrays.toString(nums2));

		System.out.println("case 2: " + getPivotIndex(nums2));
		System.out.println();
		int[] nums3 = new int[] { 2, 1, -1 };
		System.out.println("nums3: " + Arrays.toString(nums3));

		System.out.println("case 3: " + getPivotIndex(nums3));

	}

	private static int getPivotIndex(int[] nums) {
		int n = nums.length;
		int pivot = -1;
		int sum = 0;
		int[] pre = new int[n + 1];
		for (int i = 0; i <= n - 1; i++) {
			sum += nums[i];
			pre[i + 1] += pre[i] + nums[i];
		}
		// since the condition says excluding current index
		// we compare pre at i with total - next pre
		for (int i = 0; i <= n - 1; i++) {
			if (pre[i] == sum - pre[i + 1]) {
				pivot = i;
				break;
			}
		}

		return pivot;

	}

}
