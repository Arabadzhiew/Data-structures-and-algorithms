package com.arabadzhiev.algorithms.linkedLists;

import com.arabadzhiev.collections.LinkedListNode;

public class DeleteMiddle {
	public static <T> void deleteNode(LinkedListNode<T> node) {
		if(node == null || node.getNext() == null) {
			return;
		}
		
		node.setValue(node.getNext().getValue());
		node.setNext(node.getNext().getNext());
	
	}
}
