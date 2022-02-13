package com.arabadzhiev.bitman;

public class LargestAndSmallest {
	public static void printLargestAndSmallest(int num) {
		if(num < 0) {
			System.out.println("ERROR");
		}else if(num == 0 || num == 1) {
			System.out.println("Next Smallest: " + num + ", " +  "Next Largest: " + num);
		}
		
		int numOnes = countOnes(num);
		
		int smallest = num - 1;
		while(countOnes(smallest) != numOnes && num > 1) {
			smallest--;
		}
		
		int largest = num + 1;
		while(countOnes(largest) != numOnes && num < Integer.MAX_VALUE) {
			largest++;
		}
		
		System.out.println("Next Smallest: " + smallest + ", " +  "Next Largest: " +largest);
	}
	
	private static int countOnes(int num) {
		int ones = 0;
		
		for(int i = 0; i < 32; i++) {
			if((num & (1 << i)) != 0) {
				ones++;
			}
		}
		
		return ones;
	}
}
