package com.arabadzhiev.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringPermutations {
	
	public static void generate(String str) {
		StringBuilder top = new StringBuilder(str);
		
		for(StringBuilder sb : generate(top)) {
			System.out.println(sb);
		}
	}
	
	private static List<StringBuilder> generate(StringBuilder sb){
		
		if(sb.length() == 1) {//base case
			List<StringBuilder> leaf = new ArrayList<>();
			leaf.add(sb);
			return leaf;
		}
		
		List<StringBuilder> permutations = new ArrayList<>();
		for(int i = 0; i < sb.length(); i++) {
			char curr = sb.charAt(i);
			sb.deleteCharAt(i);
			
			
			for(StringBuilder permutation : generate(sb)) {
				StringBuilder perm = new StringBuilder(permutation);
				perm.append(curr);
				permutations.add(perm);
			}
			
			sb.insert(i, curr);
			
		}
		return permutations;
	}
	
	public static void generateNonDistinct(String str) {
		
		Map<Character, Integer> charMap = generateCharMap(str);
		
		List<String> permutations = new ArrayList<>();
		
		generateNonDistinct("", str.length(), charMap, permutations);
		
		System.out.println(charMap.keySet().size());
		
		for(String s : permutations) {
			System.out.println(s);
		}
	}
	
	private static void generateNonDistinct(String s, int remaining, Map<Character, Integer> chars,
			List<String> perms){
		
		if(remaining == 0) {
			perms.add(s);
			return;
		}
		
		for(Character c : chars.keySet()) {
			int count = chars.get(c);
			if(count > 0) {
				chars.put(c, count - 1);
				generateNonDistinct(s + c, remaining - 1, chars, perms);
				chars.put(c, count);
			}
		}
	}
	
	private static Map<Character, Integer> generateCharMap(String str){
		Map<Character, Integer> map = new HashMap<>();
		
		for(char c : str.toCharArray()) {
			if(!map.containsKey(c)) {
				map.put(c, 0);
			}
			map.put(c, map.get(c) + 1);
		}
		
		return map;
	}
}
