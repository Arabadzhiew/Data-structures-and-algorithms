package com.arabadzhiev.algorithms.arrays;

import com.arabadzhiev.collections.ArrayList;

public class ZeroMatrix {
	
	public static void zerofy(int[][] matrix) {
		ArrayList<Coordinate> zeroPoints = new ArrayList<>();
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				if(matrix[i][j] == 0) {
					zeroPoints.add(new Coordinate(i, j));
				}
			}
		}
		for(Coordinate c : zeroPoints) {
			setRowZero(matrix, c.getX());
			setColumnZero(matrix, c.getY());
		}
	}
	
	private static void setRowZero(int[][] matrix, int row) {
		for(int i = 0; i < matrix[0].length; i++) {
			matrix[row][i] = 0;
		}
	}
	
	private static void setColumnZero(int[][] matrix, int column) {
		for(int i = 0; i < matrix.length; i++) {
			matrix[i][column] = 0;
		}
	}
	
	private static class Coordinate {
		private int x;
		private int y;
		
		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}

	}
	
}
