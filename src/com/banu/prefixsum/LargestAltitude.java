package com.banu.prefixsum;

/**
 * 
 * https://leetcode.com/problems/find-the-highest-altitude/?envType=problem-list-v2&envId=prefix-sum
 * 
 */

public class LargestAltitude {

	public static void main(String[] args) {

		int[] gain = { -5, 1, 5, 0, -7 };

		largestAltitude(gain);

	}

	public static int largestAltitude(int[] gain) {

		int[] prefixSum = new int[gain.length + 1];
		// initalize the first value
		prefixSum[0] = gain[0];
		// assume first value is the max
		int max = prefixSum[0];
		// loop through calculating the gain in prefixSum array
		// check if the max gain increasing.
		for (int i = 1; i < gain.length; ++i) {
			prefixSum[i] = prefixSum[i - 1] + gain[i];
			if (prefixSum[i] > max) {
				max = prefixSum[i - 1];
			}
		}

//		System.out.println(Arrays.toString(gain));
//		System.out.println(Arrays.toString(prefixSum));
//		System.out.println(max);
		return max > 0 ? max : 0;
	}

}
