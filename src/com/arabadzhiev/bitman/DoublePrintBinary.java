package com.arabadzhiev.bitman;

public class DoublePrintBinary {
	public static void convert(double num) {
		if(num >= 1 || num <= 0) {
			System.out.println("ERROR");
			return;
		}
		StringBuilder binary = new StringBuilder();
		binary.append('.');
		while(num != 0) {
//			if(binary.length() == 32) {
//				System.out.println("ERROR");
//				return;
//			}
			
			num *= 2;
			
			if(num >= 1) {
				binary.append(1);
				num -= 1;
			}else {
				binary.append(0);
			}
		}
		
		System.out.println(binary.toString());
	}
	
}
