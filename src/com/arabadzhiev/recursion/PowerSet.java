package com.arabadzhiev.recursion;

import java.util.ArrayList;

public class PowerSet {
	
	public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
		ArrayList<ArrayList<Integer>> allSubsets;
		
		if(set.size() == index) {
			allSubsets = new ArrayList<>();
			allSubsets.add(new ArrayList<>());
		}else {
			allSubsets = getSubsets(set, index + 1);
			Integer item = set.get(index);
			
			ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<>();
			
			for(ArrayList<Integer> subset : allSubsets) {
				ArrayList<Integer> newSubset = new ArrayList<>();
				newSubset.addAll(subset);
				newSubset.add(item);
				moreSubsets.add(newSubset);
			}
			allSubsets.addAll(moreSubsets);
		}
		
		return allSubsets;
	}
}
