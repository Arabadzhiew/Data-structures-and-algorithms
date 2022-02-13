package com.arabadzhiev.bitman;

public class BinaryInsertion {
	public static int insert(int n, int m, int j, int i) {
		
		int pureMask = 1 << i;
		int mask = ~pureMask;
		
		for(int t = i; t <= j; t++) {
			n &= mask;
			pureMask <<= 1;
			mask = ~pureMask;
		}
		
		m <<= i;
		
		return n | m;
	}
}
