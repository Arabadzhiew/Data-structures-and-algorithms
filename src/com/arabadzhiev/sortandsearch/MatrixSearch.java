package com.arabadzhiev.sortandsearch;

public class MatrixSearch {
	
	public static Location search(int[][] matrix, int searched) {
		
		int current = 0;
		
		while(current < matrix.length && current < matrix[0].length) {
			
			Location row = rowSearch(matrix, searched, current, matrix.length - 1, current);
			if(row.getX() != -1 && row.getY() != -1) {
				return row;
			}
			Location column = columnSearch(matrix, searched, current, matrix[0].length - 1, current);
			
			if(column.getX() != -1 && column.getY() != -1) {
				return column;
			}
			
			current++;
		}
		
		
		return new Location(-1, -1);
	}
	
	private static Location rowSearch(int[][] matrix, int searched, int left, int right, int row) {
		if(left > right) {
			return new Location(-1, -1);
		}
		
		int mid = (left + right) / 2;
		
		
		if(matrix[row][mid] < searched) {
			return rowSearch(matrix, searched, mid + 1, right, row);
		}else if(matrix[row][mid] > searched) {
			return rowSearch(matrix, searched, left, mid - 1, row);
		}
		
		return new Location(row, mid);
	}
	
	private static Location columnSearch(int[][] matrix, int searched, int top, int bottom, int column) {
		if(top > bottom) {
			return new Location(-1, -1);
		}
		
		int mid = (top + bottom) / 2;
		
		if(matrix[mid][column] < searched) {
			return columnSearch(matrix, searched, mid + 1, bottom, column);
		}else if(matrix[mid][column] > searched) {
			return columnSearch(matrix, searched, top, mid - 1, column);
		}
		
		return new Location(mid, column);
	}
	
	
	
	public static class Location{
		private int x;
		private int y;
		
		public Location(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}
		
		
	}
}
