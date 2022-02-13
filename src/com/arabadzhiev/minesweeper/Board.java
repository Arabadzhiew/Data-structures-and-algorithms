package com.arabadzhiev.minesweeper;

import java.util.Random;

public class Board {
	private Cell[][] grid;
	private int unrevealed;
	
	protected Board(int size) {
		grid = new Cell[size][size];
		unrevealed = size * size - size;
		
		Random rnd = new Random();
		for(int i = 0; i < size; i++) {
			int x = Math.abs(rnd.nextInt()) % size;
			int y = Math.abs(rnd.nextInt()) % size;
			
			while(grid[x][y] != null) {
				x = Math.abs(rnd.nextInt()) % size;
				y = Math.abs(rnd.nextInt()) % size;
			}
			grid[x][y] = new MineCell();
		}
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(grid[i][j] instanceof MineCell) {
					if(i - 1 >= 0 && !(grid[i-1][j] instanceof MineCell)) {
						if(grid[i-1][j] == null) {
							grid[i-1][j] = new NumberCell();
						}else {
							((NumberCell)grid[i-1][j]).incrementNumber();
							
						}
					}
					if(i + 1 < size && !(grid[i+1][j] instanceof MineCell)) {
						if(grid[i+1][j] == null) {
							grid[i+1][j] = new NumberCell();
						}else {
							((NumberCell)grid[i+1][j]).incrementNumber();
						}
					}
					if(j - 1 >= 0 && !(grid[i][j-1] instanceof MineCell)) {
						if(grid[i][j-1] == null) {
							grid[i][j-1] = new NumberCell();
						}else {
							((NumberCell)grid[i][j-1]).incrementNumber();
						}
					}
					if(j + 1 < size && !(grid[i][j+1] instanceof MineCell)) {
						if(grid[i][j+1] == null) {
							grid[i][j+1] = new NumberCell();
						}else {
							((NumberCell)grid[i][j+1]).incrementNumber();
						}
					}
					if(i - 1 >= 0 && j - 1 >= 0 && !(grid[i-1][j-1] instanceof MineCell)) {
						if(grid[i-1][j-1] == null) {
							grid[i-1][j-1] = new NumberCell();
						}else {
							((NumberCell)grid[i-1][j-1]).incrementNumber();
						}
					}
					if(i + 1 < size && j - 1 >= 0 && !(grid[i+1][j-1] instanceof MineCell)) {
						if(grid[i+1][j-1] == null) {
							grid[i+1][j-1] = new NumberCell();
						}else {
							((NumberCell)grid[i+1][j-1]).incrementNumber();
						}
					}
					if(i - 1 >= 0 && j + 1 < size && !(grid[i-1][j+1] instanceof MineCell)) {
						if(grid[i-1][j+1] == null) {
							grid[i-1][j+1] = new NumberCell();	
						}else {
							((NumberCell)grid[i-1][j+1]).incrementNumber();
						}
					}
					if(i + 1 < size && j + 1 < size && !(grid[i+1][j+1] instanceof MineCell)) {
						if(grid[i+1][j+1] == null) {
							grid[i+1][j+1] = new NumberCell();
						}else {
							((NumberCell)grid[i+1][j+1]).incrementNumber();
						}
					}
				}
			}
		}
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(grid[i][j] == null) {
					grid[i][j] = new EmptyCell(i, j);
				}
			}
		}
			
	}
	
	protected Cell[][] getGrid(){
		return grid;
	}
	
	protected void toggle(int x, int y) {
		if(x < 0 || x >= grid.length || y < 0 || y >= grid.length) {
			System.out.println("Enter valid coordinates!");
			return;
		}
		grid[x][y].toggle();
	}
	
	protected void flag(int x, int y) {
		if(x < 0 || x >= grid.length || y < 0 || y >= grid.length) {
			System.out.println("Enter valid coordinates!");
			return;
		}
		grid[x][y].setFlagged();
	}
	
	protected void decrementUnrevealed() {
		unrevealed--;
	}
	
	protected boolean hasUnrevealed() {
		return unrevealed > 0;
	}
}
