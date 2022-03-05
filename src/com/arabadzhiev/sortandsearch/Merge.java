package com.arabadzhiev.sortandsearch;

public class Merge {

	public static void mergeSortedArrays(int[] arr1, int[] arr2, int arr1Count) {
		int i = 0;
		int j = 0;
		
		while(i < arr1.length && j < arr2.length) {
			if(arr1[i] >= arr2[j]) {
				insertAt(arr1, i, arr2[j]);
				arr1[i] = arr2[j];
				i++;
				j++;
			}else {
				i++;
			}
		}
		
		while(j < arr2.length) {
			arr1[arr1Count + j] = arr2[j];
			j++;
		}
	}
	
	private static void insertAt(int[] array, int i, int value) {
		int next = array[i];
		for(int k = i + 1; k < array.length; k++) {
			int tmp = array[k];
			array[k] = next;
			next = tmp;
		}
	}
}
