package com.arabadzhiev.sortandsearch;

import java.util.HashMap;
import java.util.Map;

public class Anagrams {
	
	public static void sort(String[] anagrams, int selected) {
		
		if(selected >= anagrams.length - 2) {
			return;
		}
		
		if(anagrams.length < 2) {
			return;
		}
		
		int current = selected + 1;
		int insertIndex = selected + 1;
		
		while(current < anagrams.length) {
			
			if(areAnagrams(anagrams[selected], anagrams[current])) {
				String tmp = anagrams[insertIndex]; 
				anagrams[insertIndex] = anagrams[current];
				anagrams[current] = tmp;
			}
			current++;
		}
		
		sort(anagrams, insertIndex);
	}
	
	public static boolean areAnagrams(String s1, String s2) {
		if(s1.length() != s2.length()) {
			return false;
		}
		
		int length = s1.length();
		
		Map<Character, Integer> map1 = new HashMap<>();
		Map<Character, Integer> map2 = new HashMap<>();
		
		for(int i = 0; i < length; i++) {
			char c1 = s1.charAt(i);
			char c2 = s2.charAt(i);
			
			if(!map1.containsKey(c1)) {
				map1.put(c1, 0);
			}
			if(!map2.containsKey(c2)) {
				map2.put(c2, 0);
			}
			
			map1.put(c1, map1.get(c1) + 1);
			map2.put(c2, map2.get(c2) + 1);
		}
		
		for(Character c : map1.keySet()) {
			if(!map2.containsKey(c) || !map1.get(c).equals(map2.get(c))) {
				return false;
			}
		}
		
		return true;
	}
}
