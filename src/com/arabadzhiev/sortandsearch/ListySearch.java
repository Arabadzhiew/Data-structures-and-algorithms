package com.arabadzhiev.sortandsearch;

import com.arabadzhiev.collections.Listy;

public class ListySearch {

	public static int search(Listy list, int target) {
		return search(list, target, 0, target * 2);
	}
	
	private static int search(Listy list, int target, int left, int right) {
		if(left > right) {
			return -1;
		}
		
		int mid = (left + right) / 2;
		if(list.elementAt(mid) == target) {
			return mid;
		}else if(list.elementAt(mid) == -1 || list.elementAt(mid) > target) {
			return search(list, target, left, mid - 1);
		}
		
		return search(list, target, mid + 1, right);
	}
}
