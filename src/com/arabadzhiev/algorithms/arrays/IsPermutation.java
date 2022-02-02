package com.arabadzhiev.algorithms.arrays;

import java.util.HashMap;

public class IsPermutation {
	public static boolean isPermutation(String s1, String s2) {
		
		if(s1.length() != s2.length()) {
			return false;
		}
		
		HashMap<Character, Integer> matches = new HashMap<>();
		
		for(Character c : s1.toCharArray()) {
			if(matches.containsKey(c)) {
				matches.replace(c, matches.get(c) + 1);
			}else {
				matches.put(c, 1);
			}
		}
		
		for(Character c : s2.toCharArray()) {
			if(!matches.containsKey(c)) {
				return false;
			}
			
			matches.replace(c, matches.get(c) - 1);
			
			if(matches.get(c) < 0) {
				return false;
			}
		}
		
		for(Integer i : matches.values()) {
			if(i != 0) {
				return false;
			}
		}
		
		return true;
	}
}
