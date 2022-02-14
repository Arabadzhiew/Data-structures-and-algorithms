package com.arabadzhiev.recursion;

public class RobotGrid {
	
	
	public static int[][] findPath(char[][] grid) {
		int[][] memo = new int[grid.length][grid[0].length];
		findPath(grid, 0, 0, memo);
		return memo;
	}
	
	private static boolean findPath(char[][] grid, int i, int j, int[][] memo) {
		
		if(i >= grid.length || j >= grid[0].length) {
			return false;
		}
		
		if(grid[i][j] != ' ') {
			return false;
		}
		
		if(i == grid.length - 1 && j == grid[0].length - 1) {
			memo[i][j]++;
			return true;
		}
		
		if(memo[i][j] != 0) {
			memo[i][j]++;
			return true;
		}
		
		boolean foundAWay = findPath(grid, i + 1, j, memo) || findPath(grid, i , j + 1, memo);
		
		if(foundAWay) {
			memo[i][j]++;
		}
		
		return foundAWay;
	}
}
