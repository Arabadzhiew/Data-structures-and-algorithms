package com.arabadzhiev.minesweeper;

public class MineCell extends Cell{

	protected MineCell() {}
	
	@Override
	protected void toggle() {
		this.setShown();
		
		Game.getInstance().concludeLoss();
	}
	
	@Override
	protected String getDisplayValue() {
		if(!this.isShown()) {
			return "*";
		}
		return "@";
	}

}
