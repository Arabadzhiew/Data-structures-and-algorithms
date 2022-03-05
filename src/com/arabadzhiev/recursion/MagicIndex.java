package com.arabadzhiev.recursion;

public class MagicIndex {
	
	public static int find(int[] arr) {
		return find(arr, 0, arr.length - 1);
	}
	
	private static int find(int[] arr, int start, int end) {
		
		int midIndex = (start + end) / 2;
		
		if(start > end) {
			return -1;
		}
		
		if(arr[midIndex] == midIndex) {
			return midIndex;
		}
		
		int leftIndex = Math.min(midIndex - 1, arr[midIndex]);
		int left = find(arr, start, leftIndex);
		if(left >= 0) {
			return left;
		}
		
		int rightIndex = Math.max(midIndex + 1, arr[midIndex]);
		int right = find(arr, rightIndex, end);
		
		return right;
		
	}
}
