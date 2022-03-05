package com.arabadzhiev.recursion;

public class Mathematics {
	
	public static int multiply(int num, int multiplier) {
		if(multiplier == 0 || num == 0) {
			return 0;
		}
		
		int toAdd = 0;
		if((multiplier & 1) == 1) {
			toAdd = num;
		}
		
		return toAdd + multiply(num << 1, multiplier >> 1);
		
	}
}
