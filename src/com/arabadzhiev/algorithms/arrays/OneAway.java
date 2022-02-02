package com.arabadzhiev.algorithms.arrays;

public class OneAway {
	public static boolean oneAway(String s1, String s2) {
		if(s1.length() - s2.length() > 1 || s2.length() - s1.length() > 1) {
			return false;
		}
		
		int matchingChars = 0;
		boolean[] matchedMask = new boolean[s2.length()];
		
		for(char c1 : s1.toCharArray()) {
			for(int i = 0; i < s2.length(); i++) {
				if(!matchedMask[i]) {
					continue;
				}
				
				if(s2.charAt(i) == c1) {
					matchingChars++;
					matchedMask[i] = true;
				}
			}
		}
		
		if(s1.length() - matchingChars <= 1) {
			return true;
		}
		
		return false;
	}
	
	public static boolean oneAwayLinear(String s1, String s2) {
		
		int lengthDifference = Math.abs(s1.length() - s2.length());
		
		if(lengthDifference > 1) {
			return false;
		}
		
		if(lengthDifference == 0) {
			return equalLengthCheck(s1, s2);
		}
		return unequalLengthCheck(s1, s2);
	}
	
	private static boolean equalLengthCheck(String s1, String s2) {
		boolean matchFound = false;
		
		for(int i = 0; i < s1.length(); i++) {
			if(matchFound) {
				if(s1.charAt(i) != s2.charAt(i)) {
					return false;
				}
				continue;
			}
			if(s1.charAt(i) != s2.charAt(i)) {
				matchFound = true;
			}
		}
		return true;
	}
	
	private static boolean unequalLengthCheck(String s1, String s2) {
		String longest = s1.length() > s2.length() ? s1 : s2;
		String shortest = s1.length() > s2.length() ? s2 : s1;
		boolean matchFound = false;
		
		for(int i = 0; i < shortest.length(); i++) {
			if(matchFound) {
				if(longest.charAt(i) != shortest.charAt(i - 1)) {
					return false;
				}
				continue;
			}
			
			if(longest.charAt(i) != shortest.charAt(i)) {
				matchFound = true;
			}
		}
		
		return true;
	}
}
