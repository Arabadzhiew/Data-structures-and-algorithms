package com.arabadzhiev.minesweeper;

import java.util.Scanner;

public class Game {
	
	private static Game instance;
	
	private Board board;
	private int score;
	private boolean gameOver;
	
	private Game() {}
	
	
	public static Game getInstance() {
		if(instance == null) {
			instance = new Game();
		}
		
		return instance;
	}
	
	public boolean isOver() {
		return gameOver;
	}
	
	public void startGame() {
		board = new Board(10);
		score = 0;
		gameOver = false;
		Scanner input = new Scanner(System.in);
		
		this.update();
		while(!this.isOver()) {
			System.out.print("Make move or flag? : ");
			String next = input.nextLine();
			if(next.equals("f")) {
				System.out.print("Enter flag x: ");
				int x = input.nextInt();
				input.nextLine();
				System.out.print("\nEnter flag y: ");
				int y = input.nextInt();
				input.nextLine();
				
				this.flag(x, y);
			}else {
				System.out.print("\nEnter x: ");
				int x = input.nextInt();
				input.nextLine();
				System.out.print("\nEnter y: ");
				int y = input.nextInt();
				input.nextLine();
				
				this.makeMove(x, y);
			}
		}
		
		input.close();
	}
	
	private void makeMove(int x, int y) {
		board.toggle(x, y);
	}
	
	private void flag(int x, int y) {
		board.flag(x, y);
		update();
	}
	
	
	protected void concludeLoss() {
		BoardPrinter.printAll(board);
		System.out.println("GAME OVER! You went over a mine.\n");
		gameOver = true;
		
		replay();
	}
	
	protected void concludeWin() {
		BoardPrinter.printAll(board);
		System.out.println("YOU JUST WON! Congratulations.");
		gameOver = true;
		
		replay();
	}
	
	protected void update() {
		if(!board.hasUnrevealed()) {
			concludeWin();
			return;
		}
		BoardPrinter.printShown(board);
	}
	
	protected void revealEmptySpace(EmptyCell e) {
		Cell[][] grid = board.getGrid();
		floodFill(grid, e);
		update();
	}
	
	protected void calculateReveal() {
		board.decrementUnrevealed();
		score += 10;
	}
	
	private void floodFill(Cell[][] grid, Cell cell) {
		if(cell.isShown()) {
			return;
		}
		
		if(!(cell instanceof EmptyCell)) {
			cell.setShown();
			calculateReveal();
			return;
		}
		
		cell.setShown();
		calculateReveal();
		
		int x = ((EmptyCell)cell).getX();
		int y = ((EmptyCell)cell).getY();
		
		if(x - 1 >= 0) {
			floodFill(grid, grid[x-1][y]);
		}
		if(x + 1 < grid.length) {
			floodFill(grid, grid[x+1][y]);
		}
		if(y - 1 >= 0) {
			floodFill(grid, grid[x][y-1]);
		}
		if(y + 1 < grid.length) {
			floodFill(grid, grid[x][y+1]);
		}
	}
	
	private void replay() {
		System.out.println("Final score: " + this.score + "\n");
		System.out.print("Press Y to start a new game, or press any other key to quit: ");
		Scanner input = new Scanner(System.in);
		String decission = input.nextLine();
		
		if(decission.equalsIgnoreCase("y")) {
			this.startGame();
		}
		
		input.close();
	}
}
