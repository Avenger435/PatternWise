package com.banu.prefixsum;

/*
 * https://leetcode.com/problems/maximum-score-after-splitting-a-string/description/?envType=problem-list-v2&envId=prefix-sum
 */
public class MaxScore {

	public static void main(String[] args) {

		String input = "00111";
		System.out.println(maxScore(input));
		System.out.println(maxScore1(input));
	}

	public static int maxScore(String s) {
		if (s.isEmpty() || s.isBlank()) {
			return 0;
		}
		int maxScore = 0;
		int prevScore = maxScore;
		for (int i = 1; i <= s.length() - 1; ++i) {
			maxScore = calPreSum(s.substring(0, i), '0') + calPreSum(s.substring(i, s.length()), '1');
			if (maxScore > prevScore) {
				prevScore = maxScore;
			}
		}
		return prevScore;
	}

	public static int calPreSum(String str, char c) {
		int counter = 0;
		for (int i = 0; i <= str.length() - 1; ++i) {
			if (str.charAt(i) == c) {
				counter++;
			}
		}
		return counter;
	}

	// one pass solution:
	private static int maxScore1(String s) {
		int zeros = 0, ones = 0, res = Integer.MIN_VALUE;

		if (s.charAt(0) == '0') {
			zeros++;
		} else {
			ones++;
		}

		for (int i = 1; i < s.length(); i++) {
			res = Math.max(res, zeros - ones);
			if (s.charAt(i) == '0') {
				zeros++;
			} else {
				ones++;
			}
		}

		return res + ones;
	}

}
