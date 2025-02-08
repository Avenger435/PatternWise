package com.banu.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxOperationsKSumPairs {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		int k = 5;
		System.out.println(Arrays.toString(nums));
		System.out.println("output: " + maxOperations(nums, k));

		System.out.println();

//		int[] nums = { 2, 2, 2, 3, 1, 1, 4, 1 };
//		int k = 4;
//		System.out.println(Arrays.toString(nums));
//		System.out.println("output: " + maxOperations(nums, k));
//
//		System.out.println();
//		int[] arr1 = { 3, 1, 3, 4, 3 };
//		int m = 6;
//		System.out.println("output: " + maxOperations(arr1, m));
//		System.out.println();
//		int[] arr = { 4, 4, 1, 3, 1, 3, 2, 2, 5, 5, 1, 5, 2, 1, 2, 3, 5, 4 };
//		int l = 2;
//		System.out.println("output: " + maxOperations(arr, l));
	}

	//

	private static int maxOperations(int[] nums, int k) {
		Arrays.sort(nums);
		int left = 0;
		int right = nums.length - 1;
		int counter = 0;
		while (left < right) {
			int sum = nums[left] + nums[right];
			if (sum == k) {
				counter++;
				left++;
				right--;
			}
			if (sum < k) {
				left++;
			}
			if (sum > k) {
				right--;
			}
		}

		return counter;
	}

}
