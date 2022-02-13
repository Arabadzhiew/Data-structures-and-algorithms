package com.arabadzhiev.minesweeper;

public class NumberCell extends Cell{
	
	private int number;
	
	protected NumberCell() {
		this.number = 1;
	}
	
	protected int getNumber() {
		return this.number;
	}
	
	protected void incrementNumber() {
		this.number++;
	}

	@Override
	protected void toggle() {
		if(!this.isShown()) {
			Game.getInstance().calculateReveal();
		}
		this.setShown();
		
		Game.getInstance().update();
	}

	@Override
	protected String getDisplayValue() {
		return Integer.toString(number);
	}
}
