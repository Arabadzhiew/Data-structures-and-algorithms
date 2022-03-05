package com.arabadzhiev.sortandsearch;

import java.util.ArrayList;
import java.util.List;

public class PeaksAndValleys {
	
	public static void format(int[] array, int digits) {
		sort(array, digits, 10);
		
		int length = array.length;
		for(int i = 1; i < length; i += 2) {
			int tmp = array[i];
			array[i] = array[i - 1];
			array[i - 1] = tmp; 
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void sort(int[] array, int digits, int base) {
		
		List<Integer>[] buckets = new ArrayList[base];
		
		for(int i = 0; i < buckets.length; i++) {
			buckets[i] = new ArrayList<>();
		}
		
		int power = 1;
		
		for(int i = 0; i < digits; i++) {
			for(List<Integer> bucket : buckets) {
				bucket.clear();
			}
			
			for(int j = 0; j < array.length; j++) {
				int digit = array[j] / power % base;
				buckets[digit].add(array[j]);
			}
			
			int index = 0;
			for(List<Integer> bucket : buckets) {
				for(Integer val : bucket) {
					array[index] = val;
					index++;
				}
			}
			
			power *= base;
		}
	}
}
