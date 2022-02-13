package com.arabadzhiev.bitman;

public class MonochromeScreen {
	public static void drawHorizontalLine(byte[] screen, int width, int x1, int x2, int y){
		if(x1 < 0 || x2 >= width) {
			throw new IndexOutOfBoundsException("x2 greater than width");
		}
		int trueWidth = width / 8;
		
		
		int column = x2 / 8;
		
		for(int i = x2; i >= x1; i--) {
			int index = trueWidth * y + column;
			int bit = i % 8;
			byte mask = (byte) (128 >>> bit);
			screen[index] |= mask;
			if(bit == 0) {
				column --;
			}
		}
	}
}
