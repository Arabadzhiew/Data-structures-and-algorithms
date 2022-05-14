package com.arabadzhiev.sortandsearch;

public class BinarySearch {
	
	public static int search(int[] nums, int target) {
		int rtrn = search(nums,0, nums.length - 1, target);
        return rtrn;
    }
    
    private static int search(int[] nums, int left, int right, int target){
        
        if(left > right){
            return -1;
        }
        
        int middle = (left + right) / 2;
        
        if(nums[middle] < target){
            return search(nums, middle + 1, right, target);
        }else if(nums[middle] > target){
        	return search(nums, left, middle - 1, target);
        }

        return middle;
        
    }
	
}
