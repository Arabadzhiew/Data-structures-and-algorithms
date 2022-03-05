package com.arabadzhiev.sortandsearch;

public class RotatedSearch {
	
	public static int search(int[] array, int searched) {
		int offset = 1;
		int previous = array[0];
		while(offset < array.length) {
			if(previous > array[offset]) {
				return search(array, searched, 0, array.length, offset);
			}
			offset++;
		}
		
		return search(array, searched, 0, array.length, 0);
	}
	
	private static int search(int[] array, int searched, int left, int right, int offset) {
		
		if(left > right) {
			return - 1;
		}
		
		int mid = (left + right) / 2;
		
		int trueMid = getTrueIndex(mid, offset, array.length);
		
//		System.out.println(array[trueMid]);
		
		if(array[trueMid] == searched) {
			return trueMid;
		}else if(array[trueMid] < searched) {
			return search(array, searched, mid + 1, right, offset);
		}
		
		return search(array, searched, left, mid - 1, offset);
		
	}
	
	private static int getTrueIndex(int index, int offset, int arrLength) {
		for(int i = 0; i < offset; i++) {
			index++;
			if(index >= arrLength) {
				index = 0;
			}
		}
		
		return index;
	}
}
