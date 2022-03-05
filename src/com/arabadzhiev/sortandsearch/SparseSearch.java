package com.arabadzhiev.sortandsearch;

public class SparseSearch {
	
	public static int sparseSearch(String[] array, String target) {
		return sparseSearch(array, target, 0, array.length - 1);
	}
	
	private static int sparseSearch(String[] array, String target, int left, int right) {
		if(left > right) {
			return -1;
		}
		
		int mid = (left + right) / 2;
		
		if(array[mid].isEmpty()) {
			int midLeft = mid - 1;
			int midRight = mid + 1;
			
			while(true) {
				if(midLeft < left && midRight > right) {
					return -1;
				}
				
				if(midLeft >= left && !array[midLeft].isEmpty()) {
					mid = midLeft;
					break;
				}else if(midRight <= right && !array[midRight].isEmpty()) {
					mid = midRight;
					break;
				}
				midLeft--;
				midRight++;
			}
		}
		
		
		if(array[mid].compareTo(target) < 0) {
			return sparseSearch(array, target, mid + 1, right);
		}else if(array[mid].compareTo(target) > 0) {
			return sparseSearch(array, target, left, mid - 1);
		}
		
		return mid;
	}
}
