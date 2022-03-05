package com.arabadzhiev.recursion;

public class Parentheses {
	public static void possible(int n) {
		possible(new StringBuilder(), n, n);
	}
	
	private static void possible(StringBuilder combo, int left, int right) {
		if(left == 0 && right == 0) {
			System.out.println(combo.toString());
			return;
		}
		
		if(left == right) {
			combo.append('(');
			possible(combo, left - 1, right);
			combo.deleteCharAt(combo.length() - 1);
		}else {
			if(left > 0) {
				combo.append('(');
				possible(combo, left - 1, right);
				combo.deleteCharAt(combo.length() - 1);
			}
			if(right > 0) {
				combo.append(')');
				possible(combo, left, right - 1);
				combo.deleteCharAt(combo.length() - 1);
			}
		}

		

		
	}
}
