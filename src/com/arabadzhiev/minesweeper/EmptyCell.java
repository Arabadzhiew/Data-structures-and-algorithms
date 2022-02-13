package com.arabadzhiev.minesweeper;

public class EmptyCell extends Cell{
	
	private int x;
	private int y;
	
	protected EmptyCell(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	protected int getX() {
		return x;
	}
	
	protected int getY() {
		return y;
	}

	@Override
	protected void toggle() {
		
		Game.getInstance().revealEmptySpace(this);
		
	}
	
	@Override
	protected String getDisplayValue() {
		return " ";
	}

}
