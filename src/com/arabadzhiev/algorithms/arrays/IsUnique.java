package com.arabadzhiev.algorithms.arrays;

public class IsUnique {
	public static boolean isUnique(String s) {
		if(s.length() > 128) {
			return false;
		}
		
		boolean[] present = new boolean[128];
		
		
		for(char c : s.toCharArray()) {
			if(present[c]) {
				return false;
			}
			present[c] = true;
		}
		return true;
	}
	
	public static boolean isUniqueInPlace(String s) {
		if(s.length() > 128) {
			return false;
		}
		
		
		for(int i = 0; i < s.length(); i++) {
			for(int j = i + 1; j < s.length(); j++) {
				if(s.charAt(j) == s.charAt(i)) {
					return false;
				}
			}
		}
		
		return true;
	}
}
