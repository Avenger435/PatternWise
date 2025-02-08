package com.banu.twopointers;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MaxAreaWater {

	public static void main(String[] args) {

		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
//		int[] height= {1,1};
//		int[] height = { 2, 3, 4, 5, 18, 17, 6 };

		System.out.println(Arrays.toString(height));
		System.out.println(maxArea(height));
	}

	public static int maxArea(int[] height) {
		int right = height.length - 1;
		int maxArea = 0;
		int left = 0;
		while (left < right) {
			maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return maxArea;

	}

}
