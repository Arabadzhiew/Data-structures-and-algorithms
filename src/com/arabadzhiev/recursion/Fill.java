package com.arabadzhiev.recursion;

public class Fill {
	public static void floodFill(char[][] canvas, int r, int c, char replacement) {
		
		floodFill(canvas, r, c, canvas[r][c], replacement);
	}
	
	private static void floodFill(char[][] canvas, int r, int c, char value, char replacement) {
		if(r >= canvas.length || c >= canvas[0].length || r < 0 || c < 0) {
			return;
		}
		
		if(canvas[r][c] == value) {
			canvas[r][c] = replacement;
			
//			visualization of the algorithm
//			for(char[] inner : canvas) {
//				for(char ch : inner) {
//					System.out.print(ch);
//				}
//				System.out.println();
//			}
//			System.out.println();
			floodFill(canvas, r - 1, c, value, replacement);
			floodFill(canvas, r + 1, c, value, replacement);
			floodFill(canvas, r, c - 1, value, replacement);
			floodFill(canvas, r, c + 1, value, replacement);
		}
	}
}
