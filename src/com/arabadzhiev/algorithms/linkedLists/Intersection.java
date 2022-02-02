package com.arabadzhiev.algorithms.linkedLists;

import com.arabadzhiev.collections.HashMap;
import com.arabadzhiev.collections.LinkedListNode;

public class Intersection {
	public static <T> LinkedListNode<T> findIntersection(LinkedListNode<T> first,LinkedListNode<T> second){
		HashMap<T, LinkedListNode<T>> map = new HashMap<>();
		
		
		while(second != null) {
			map.add(second.getValue(), second);
			second = second.getNext();
		}
		
		while(first != null) {
			LinkedListNode<T> node = map.get(first.getValue());
			if(node != null) {
				if(node == first) {
					return node;
				}
			}
			first = first.getNext();
		}
		
		return null;
	}
}
