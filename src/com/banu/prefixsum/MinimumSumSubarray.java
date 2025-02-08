package com.banu.prefixsum;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * https://leetcode.com/problems/minimum-positive-sum-subarray/description/?envType=problem-list-v2&envId=prefix-sum
 * 
 * 
 */
public class MinimumSumSubarray {

	public static void main(String[] args) {

		// case1:
		List<Integer> list = Arrays.asList(-23, 2, -12);

//		System.out.println("sublist: " + list.subList(0, 1));s

		int l = 1;
		int r = 2;
		int case1Ouptut = 1;
//		System.out.println(minimumSumSubarray(list, l, r));
		System.out.println(minSubArraySum(list, l, r));

	}

	// preSum

	public static int minSubArraySum(List<Integer> nums, int l, int r) {

		int n = nums.size();
		int[] pre = new int[n + 1];
		pre[0] = nums.get(0);

		for (int i = 1; i <= n; i++) {
			pre[i] = pre[i - 1] + nums.get(i - 1);
		}
		System.out.println(Arrays.toString(pre));

		int res = Integer.MAX_VALUE;

		for (int k = l; k <= r; k++) {
			for (int i = 0; i + k <= n; i++) {
				int sum = pre[i + k] - pre[i];
				if (sum > 0) {
					res = Math.min(sum, res);
				}
			}
		}

		return res == Integer.MAX_VALUE ? -1 : res;
	}

	public static int minimumSumSubarray(List<Integer> nums, int l, int r) {

		int minVal = Integer.MAX_VALUE;
		for (int k = l; k <= r; ++k) {
			int val = findMinSumSubarray(nums, k);
			if (val < minVal && val > 0)
				minVal = val;
		}
		return minVal < Integer.MAX_VALUE ? minVal : -1;
	}

	private static int findMinSumSubarray(List<Integer> nums, int length) {
		int minVal = Integer.MAX_VALUE;
		int startIndex = 0;
		int endIndex = startIndex + length;
		while (endIndex <= nums.size()) {
			int sum = nums.subList(startIndex, endIndex).stream().collect(Collectors.summingInt(Integer::intValue));
			if (sum < minVal && sum > 0)
				minVal = sum;
			endIndex++;
			startIndex++;
		}
		return minVal < Integer.MAX_VALUE ? minVal : -1;
	}

}
