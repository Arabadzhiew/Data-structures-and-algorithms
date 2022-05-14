package com.arabadzhiev.algorithms.arrays;

import java.util.ArrayList;
import java.util.List;

public class Array {
	
	public static void mergeSort(int[] arr) {
		mergeSort(arr, 0 , arr.length);
	}
	
	private static void mergeSort(int[] arr, int left, int right) {
		if(right - left < 2) {
			return;
		}
		
		int middle = (left + right) / 2;
		
		mergeSort(arr, middle, right);
		mergeSort(arr, left, middle);
		
		merge(arr, left, right);
	}
	
	private static void merge(int[] arr, int left, int right) {
		
		int[] merged = new int[right - left];
		
		int middle = (left + right) / 2;
		
		int j = left;
		int k = middle;
		
		for(int i = 0; i < merged.length; i++) {
			if(j < middle && k < right) {
				if(arr[j] < arr[k]) {
					merged[i] = arr[j];
					j++; 
				}else {
					merged[i] = arr[k];
					k++;
				}
			}else if(j < middle) {
				merged[i] = arr[j];
				j++;
			}else if(k < right){
				merged[i] = arr[k];
				k++;
			}
		}
		
		for(int i = 0; i < merged.length; i++) {
			arr[i + left] = merged[i];
		}
		
		
	}
	
//	public static void mergeSort(int[] arr) {
//		mergeSort(arr, 0, arr.length);
//	}
//	
//	private static void mergeSort(int[] arr, int left, int right){
//		
//		if(right - left < 2) {
//			return;
//		}
//		
//		int middle = (left + right) / 2;
//		
//		
//		mergeSort(arr, left, middle);
//		mergeSort(arr, middle, right);
//		
//		merge(arr, left, middle, right);
//	}
//	
//	private static void merge(int[] arr, int left, int middle, int right) {
//		
//		int[] merged = new int[right - left];
//		int i = left;
//		int j = middle;
//		
//		for(int k = 0; k < merged.length; k++) {
//			if(i < middle && j < right) {
//				if(arr[i] < arr[j]) {
//					merged[k] = arr[i];
//					i++;
//				}else if(arr[i] >= arr[j]) {
//					merged[k] = arr[j];
//					j++;
//				}
//			}else if(i < middle) {
//				merged[k] = arr[i];
//				i++;
//			}else if(j < right) {
//				merged[k] = arr[j];
//				j++;
//			}
//		}
//		
//		for(int k = left; k < right; k++) {
//			arr[k] = merged[k - left];
//		}
//	}
	
	public static void quickSort(int[] arr) {
		if(arr.length < 2) {
			return;
		}
		
		int pivot = arr[0];
		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();
		
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] < pivot) {
				left.add(arr[i]);
			}else if(arr[i] >= pivot) {
				right.add(arr[i]);
			}
		}
		
		
		int leftArr[] = left.stream()
							.mapToInt(i -> i.intValue())
							.toArray();
		int rightArr[] = right.stream()
							.mapToInt(i -> i.intValue())
							.toArray();
		
		
//		for(int i = 0; i < left.size(); i++) {
//			leftArr[i] = left.get(i);
//		}
//		for(int i = 0; i < right.size(); i++) {
//			rightArr[i] = right.get(i);
//		}
		
		quickSort(leftArr);
		quickSort(rightArr);
		
		int arrIndex = 0;
		
		for(int i = 0; i < leftArr.length; i++) {
			arr[arrIndex] = leftArr[i];
			arrIndex++;
		}
		
		arr[arrIndex] = pivot;
		arrIndex++;
		
		for(int i = 0; i < rightArr.length; i++) {
			arr[arrIndex] = rightArr[i];
			arrIndex++;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void radixSort(int[] array, int digits, int base) {
		
		List<Integer>[] buckets = new ArrayList[base];
		
		for(int i = 0; i < buckets.length; i++) {
			buckets[i] = new ArrayList<>();
		}
		
		int digit = 1;
		
		for(int i = 0; i < digits; i++) {
			for(List<Integer> bucket : buckets) {
				bucket.clear();
			}
			for(int j = 0; j < array.length; j++) {
				int current = array[j] / digit % base;
				buckets[current].add(array[j]);
			}
			
			int index = 0;
			for(List<Integer> bucket : buckets) {
				for(Integer val : bucket) {
					array[index] = val;
					index++;
				}
			}
			
			digit *= base;
		}
	}
}
