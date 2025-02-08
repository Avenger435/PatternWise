package com.banu.prefixsum;

import java.util.ArrayList;
import java.util.List;

public class MinimumSubArrLen {

	public static void main(String[] args) {

//		int[] nums = { 2, 3, 1, 2, 4, 3 };
//		int target = 7;
//		int[] nums1 = { 1, 4, 4 };
//		int target1 = 4;

		int[] nums1 = { 1, 2, 3, 4, 5 };
		int target1 = 11;

//		System.out.println(minSubArrayLen(target, nums));
		System.out.println(minSubArrayLen(target1, nums1));

	}

	public static int minSubArrayLen(int target, int[] nums) {

		int minLength = Integer.MAX_VALUE;
		int sum = 0;
		int windowStart = 0;
		for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
			sum += nums[windowEnd];
			while (sum >= target) {
				minLength = Math.min(minLength, windowEnd - windowStart + 1);
				sum -= nums[windowStart];
				windowStart++;
			}

		}
		return minLength == Integer.MAX_VALUE ? 0 : minLength;
	}

	public static int getArraySum(int[] nums, int start, int end) {

		int sum = 0;
		for (int i = start; i <= end; i++) {
			sum += nums[i];
		}
		return sum;
	}

}
