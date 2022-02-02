package com.arabadzhiev.algorithms.linkedLists;

import com.arabadzhiev.collections.LinkedList;
import com.arabadzhiev.collections.LinkedList.Node;

public class KTh {
	
	public static <T> T getFromLast(LinkedList<T> list, int index){
		int length = 0;
		for(T value : list) {
			length++;
		}
		
		Node<T> node = list.getFirstNode();
		
		for(int i = 0; i < length - index - 1; i++) {
			node = node.getNext();
		}
		
		return node.getValue();
	}

}
