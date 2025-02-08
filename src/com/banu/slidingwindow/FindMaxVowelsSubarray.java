package com.banu.slidingwindow;

/**
 * https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/?envType=study-plan-v2&envId=leetcode-75
 */
public class FindMaxVowelsSubarray {

	public static void main(String[] args) {

		String s = "weallloveyou";
		int k = 7;
		long start = System.currentTimeMillis();
		int output = maxVowels(s, k);
		System.out.println("time taken: " + (System.currentTimeMillis() - start));
		System.out.println(output);
		if (output == 4)
			System.out.println("passed");
		else
			System.out.println("failed");
	}

	private static int maxVowels(String s, int k) {
		int max = 0;
		for (int i = 0; i < k; i++) {
			if (isVowel(s.charAt(i)))
				max++;
		}
		int ans = max, len = s.length();
		for (int i = k; i < len; i++) {
			if (isVowel(s.charAt(i)))
				max++;
			if (isVowel(s.charAt(i - k)))
				max--;
			if (ans < max)
				ans = max;
		}
		return ans;
	}

	private static boolean isVowel(char c) {
		return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
	}

}
