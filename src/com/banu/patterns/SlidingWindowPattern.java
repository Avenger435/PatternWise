package com.banu.patterns;

public class SlidingWindowPattern {

	public static int minSubArrayLen(int target, int[] nums) {

		int minLength = Integer.MAX_VALUE;
		int sum = 0;
		// start at 0
		int windowStart = 0;
		// add elements as we go from the right
		for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
			sum += nums[windowEnd];
			// if target is less - remove the start element one by one.
			while (sum >= target) {
				// keep track of minimum length
				minLength = Math.min(minLength, windowEnd - windowStart + 1);
				// remove the start element from the sum
				sum -= nums[windowStart];
				// move the start pointer ahead by 1
				windowStart++;
			}

		}
		// check if min length is max value or 0 and return accordingly.
		return minLength == Integer.MAX_VALUE ? 0 : minLength;
	}
}
