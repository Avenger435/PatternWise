package com.banu.util;

public class PresumUtil {

	public static int[] calculatePresum(int[] nums) {
		int[] prefixSum = new int[nums.length + 1];
		for (int i = 1; i < nums.length; ++i) {
			prefixSum[i] += prefixSum[i - 1] + nums[i - 1];
		}
		return prefixSum;
	}

}
