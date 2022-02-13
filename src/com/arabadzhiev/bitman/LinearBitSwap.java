package com.arabadzhiev.bitman;

public class LinearBitSwap {
	public static int swap(int target) {
		
//		for(int i = 0; i < 32; i += 2) {
//			int n1 = target & (1 << i);
//			int n2 = target & (1 << i + 1);
//			
//			if(((n1== 0 && n2 != 0) || (n1 != 0 && n2 == 0))){
//				int mask = 1 << i;
//				target ^= mask;
//				mask <<= 1;
//				target ^= mask;
//			}
//		}
//		
//		return target;
		
		return ( ((target & 0xaaaaaaaa) >>> 1) | ((target & 0x55555555) << 1) );
	}
}
