package com.arabadzhiev.minesweeper;

public class BoardPrinter {
	
	
	public static void printShown(Board board) {
		Cell[][] grid = board.getGrid();
		System.out.println("\n");
		System.out.print("   ");
		for(int i = 0; i < grid.length; i++) {
			System.out.print(" " + i);
		}
		System.out.println();
		int rowI = 0;
		for(Cell[] row : grid) {
			System.out.print(rowI + " |");
			rowI++;
			for(Cell c : row) {
				if(!c.isShown()) {
					if(!c.isFlagged()) {
						System.out.print(" ?");
					}else {
						System.out.print(" #");
					}
				}else {
					System.out.print(" " + c.getDisplayValue());
				}
			}
			System.out.print(" |");
			System.out.println();
		}
	}
	
	public static void printAll(Board board) {
		Cell[][] grid = board.getGrid();
		System.out.println("\n");
		System.out.println();
		for(Cell[] row : grid) {
			System.out.print("|");
			for(Cell c : row) {
				System.out.print(" " + c.getDisplayValue());
			}
			System.out.print(" |");
			System.out.println();
		}
	}
}
