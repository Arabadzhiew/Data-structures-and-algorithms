package com.arabadzhiev.recursion;

public class Staircase {
	
	public static int possibleWaysToClimb(int n){
		return possibleWaysToClimb(n, 0, new int[n + 1]);
	}
	
	private static int possibleWaysToClimb(int n, int current, int[] memo) {
		if(current == n) {
			return 1;
		}
		
		if(current > n) {
			return 0;
		}
		
		
		if(memo[current] == 0) {
			memo[current] = possibleWaysToClimb(n, current + 1, memo) + 
					possibleWaysToClimb(n, current + 2, memo) + 
					possibleWaysToClimb(n, current + 3, memo);
		}
		
		return memo[current];
	}
}
