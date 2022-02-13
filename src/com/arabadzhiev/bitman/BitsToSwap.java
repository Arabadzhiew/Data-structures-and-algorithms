package com.arabadzhiev.bitman;

public class BitsToSwap {
	public static int bitCount(int a, int b) {
		int swapBits = a ^ b;
		
		if(swapBits == 0) {
			return 0;
		}
		
		int count = 0;
		int mask = 1;
		
		while(mask != 0) {
			if((swapBits & mask) != 0) {
				count++;
			}
			mask <<= 1;
		}
		
		return count;
	}
}
