package com.arabadzhiev.algorithms.linkedLists;

import com.arabadzhiev.collections.HashSet;
import com.arabadzhiev.collections.LinkedList;
import com.arabadzhiev.collections.LinkedList.Node;

public class RemuveDups {
	
	public static <T> void removeDups(LinkedList<T> list) {
		Node<T> node = list.getFirstNode();
		HashSet<T> repetitions = new HashSet<>();
		
		int index = 0;
		while(node != null) {
			if(repetitions.contains(node.getValue())) {
				list.remove(index);
				node = node.getNext();
				continue;
			}
			
			repetitions.add(node.getValue());
			node = node.getNext();
			index++;
		}

	}
	
	private static <T> T reverseLinkedList(LinkedList<T> list, Node<T> node) {
		if(node.getNext() == null) {
			return node.getValue();
		}
		
		list.add(reverseLinkedList(list, node.getNext()));
		list.remove(0);
		return node.getValue();
	}
	
	public static <T> void reverseLinkedList(LinkedList<T> list) {
		list.add(reverseLinkedList(list, list.getFirstNode()));
		list.remove(0);
	}
}
