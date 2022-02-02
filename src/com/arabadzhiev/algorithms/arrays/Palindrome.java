package com.arabadzhiev.algorithms.arrays;

public class Palindrome {
	
	public static boolean isPalindromePermutation(String s) {
		
		if(s.length() < 2) {
			return true;
		}
		
		int[] letters = new int[26];
		int letterCount = 0;
		
		for(char c : s.toCharArray()) {
			if(c - 'a' < 26 && c - 'a' > 0) {
				letters[c - 'a']++;
				letterCount++;
			}else if(c - 'A' < 26 && c - 'A' > 0) {
				letters[c - 'A']++;
				letterCount++;
			}
		}
		
		if(letterCount % 2 == 0) {
			for(int i : letters) {
				if(i % 2 != 0) {
					return false;
				}
			}
		}else {
			int oddNumbers = 0;
			for(int i : letters) {
				if(i % 2 != 0) {
					oddNumbers++;
					if(oddNumbers > 1) {
						return false;
					}
				}
			}
			if(oddNumbers == 0) {
				return false;
			}
		}
		
		return true;

	}
	
}
