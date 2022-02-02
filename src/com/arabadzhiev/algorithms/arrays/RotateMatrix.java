package com.arabadzhiev.algorithms.arrays;


public class RotateMatrix {
	public static int[][] rotate90Degrees(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		
		int[][] temporary = new int[m][n];
		
		int column = n - 1;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				temporary[j][column] = matrix[i][j];
			}
			column--;
		}
		
		
		return temporary;
	}
	
}
