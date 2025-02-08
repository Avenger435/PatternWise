package com.banu.search;

import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 4, 5, 6, 7, 9, 10 };
//		int[] nums = { 5 };
		int target = 5;
		int binarySearch = binarySearch2(nums, target);
		System.out.println(binarySearch);
	}

	public static int binarySearch(int[] nums, int target) {

//		return IntStream.of(nums).filter((i) -> i == target).findFirst().orElse(-1);
		return IntStream.range(0, nums.length).filter((i) -> nums[i] == target).findFirst().orElse(-1);
	}

	public static int binarySearch2(int[] nums, int target) {

		int index = Binary(nums, 0, nums.length - 1, target);
		return index;
	}

	private static int Binary(int[] nums, int low, int high, int key) {

		if (low > high) {
			return -1;
		}
		int mid = low + (high - low) / 2;

		if (nums[mid] == key)
			return mid;

		if (nums[mid] < key) {
			// high=mid-1
			return Binary(nums, low, mid - 1, key);
		} else {
			return Binary(nums, mid + 1, high, key);
		}

	}

}
