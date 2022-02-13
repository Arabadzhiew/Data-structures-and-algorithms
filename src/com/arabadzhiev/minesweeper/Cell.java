package com.arabadzhiev.minesweeper;

public abstract class Cell {
	
	private boolean shown = false;
	private boolean flagged = false;
	
	protected boolean isShown() {
		return shown;
	}
	protected void setShown() {
		this.shown = true;
	}
	protected boolean isFlagged() {
		return flagged;
	}
	protected void setFlagged() {
		this.flagged = true;
	}
	
	protected abstract void toggle();
	
	protected abstract String getDisplayValue();
	
}
