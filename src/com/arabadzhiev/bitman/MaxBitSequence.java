package com.arabadzhiev.bitman;

public class MaxBitSequence {
	public static int maxOneSequence(int num) {
		if(~num == 0) {
			return Integer.BYTES * 8;
		}
		
		int currentSequence = 0;
		int previousSequence = 0;
		int maxSequence = 1;
		
		for(int i = 0; i < 32; i++) {
			if((num & (1 << i)) != 0) {
				currentSequence++;
			}else {
				if(maxSequence < currentSequence + previousSequence) {
					maxSequence = currentSequence + 1 + previousSequence;
				}
				previousSequence = currentSequence;
				currentSequence = 0;
			}
		}
		
		return maxSequence;
	}
}
