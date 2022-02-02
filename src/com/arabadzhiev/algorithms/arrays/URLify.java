package com.arabadzhiev.algorithms.arrays;

public class URLify {
	
	public static String URLifyMethod(String s) {
		char[] initial = s.toCharArray();
		int spaces = 0;
		
		for(char c : initial) {
			if(c == ' ') {
				spaces++;
			}
		}
		
		if(spaces == 0) {
			return s;
		}
		
		char[] converted = new char[initial.length + spaces * 2];
		
		int cIndex = 0;
		for(int i = 0; i < initial.length; i++) {
			if(initial[i] == ' ') {
				converted[cIndex] = '%';
				converted[cIndex + 1] = '2';
				converted[cIndex + 2] = '0';
				cIndex += 3;
			}else {
				converted[cIndex] = initial[i];
				cIndex++;
			}
		}
		
		return new String(converted);
	}
}
