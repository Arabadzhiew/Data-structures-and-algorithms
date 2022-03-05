package com.arabadzhiev.sortandsearch;

public class FindDuplicates {
	
	public static void printDuplicates(int[] array) {
		
		byte[] vector = new byte[4000];
		
		for(int i = 0; i < array.length; i++) {
			int occurance = vector[(array[i] - 1) / 8];
			if((occurance & (1 << (array[i] % 8))) != 0) {
				System.out.println(array[i]);
				continue;
			}
			
			vector[(array[i] - 1) / 8] = (byte)(1 << (array[i] % 8));
		}
	}
}
