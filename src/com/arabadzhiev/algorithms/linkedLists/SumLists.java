package com.arabadzhiev.algorithms.linkedLists;

import com.arabadzhiev.collections.ArrayList;
import com.arabadzhiev.collections.LinkedListNode;
import com.arabadzhiev.utility.StringBuilder;

public class SumLists {
	public static int sumLists(LinkedListNode<Integer> n1, LinkedListNode<Integer> n2) {
		ArrayList<Character> c1 = new ArrayList<>();
		ArrayList<Character> c2 = new ArrayList<>();
		
		while(n1 != null) {
			c1.add((char)(n1.getValue() + 48));
			n1 = n1.getNext();
		}
		
		while(n2 != null) {
			c2.add((char)(n2.getValue() + 48));
			n2 = n2.getNext();
		}
		
//		reverseArrayList(c1);
//		reverseArrayList(c2);
		
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		
		for(Character c : c1) {
			sb1.append(c);
		}
		for(Character c : c2) {
			sb2.append(c);
		}
		
		int i1 = Integer.parseInt(sb1.toString());
		int i2 = Integer.parseInt(sb2.toString());
		
		return i1 + i2;
	}
	
	
	public static <T> void reverseArrayList(ArrayList<T> list) {
		
		if(list.getSize() == 0) {
			return;
		}
		
		T value = list.get(0);
		list.remove(0);
		
		
		reverseArrayList(list);
		
		list.add(value);
	}
}
