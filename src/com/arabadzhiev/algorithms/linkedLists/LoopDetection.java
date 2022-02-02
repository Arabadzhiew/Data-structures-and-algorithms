package com.arabadzhiev.algorithms.linkedLists;

import com.arabadzhiev.collections.HashSet;
import com.arabadzhiev.collections.LinkedListNode;

public class LoopDetection {
	public static <T> LinkedListNode<T> findLoop(LinkedListNode<T> node){
		HashSet<LinkedListNode<T>> iterated = new HashSet<>();
		
		while(node != null) {
			if(iterated.contains(node)) {
				return node;
			}
			
			iterated.add(node);
			node = node.getNext();
		}
		
		return null;
	}
}
