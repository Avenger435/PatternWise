package com.banu.prefixsum;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/count-partitions-with-even-sum-difference/description/?envType=problem-list-v2&envId=prefix-sum
 */
public class CountPartitions {

	public static void main(String[] args) {

		System.out.println(countPartitions(new int[] { 10, 10, 3, 7, 6 }));

	}

	public static int countPartitions(int[] nums) {

		int[] pre = new int[nums.length];
		int n = nums.length;
		pre[0] = nums[0];
		int counter = 0;
		for (int i = 1; i < nums.length; i++) {
			pre[i] = nums[i] + pre[i - 1];
		}
		for (int i = 1; i < nums.length; i++) {
			if ((pre[i] - (pre[n - 1] - pre[i])) % 2 == 0)
				counter++;
		}
		return counter;
	}
}
