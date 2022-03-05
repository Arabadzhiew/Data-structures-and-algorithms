package com.arabadzhiev.recursion;

import java.util.HashSet;
import java.util.Set;

public class Cents {
	public static int calculateCombinations(int n) {
		return calculateCombinations(n, 0, 0, new HashSet<>());
	}
	
	private static int calculateCombinations(int n, int current, int currentCombo, Set<Integer> combos) {
		if(current == n) {
			if(combos.contains(currentCombo)) {
				return 0;
			}
			
			combos.add(currentCombo);
			return 1;
		}else if(current > n) {
			return 0;
		}
		
		return calculateCombinations(n, current + 1, currentCombo + 1, combos) + 
				calculateCombinations(n, current + 5, currentCombo + 1, combos) +
				calculateCombinations(n, current + 10, currentCombo + 1, combos) + 
				calculateCombinations(n, current + 25, currentCombo + 1, combos);
	}
}
