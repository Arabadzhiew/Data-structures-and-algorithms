package com.arabadzhiev.algorithms.linkedLists;

import com.arabadzhiev.collections.LinkedListNode;

public class Partition {
	
	public static void partition(LinkedListNode<Integer> beggining, Integer pivot) {
		LinkedListNode<Integer> node = beggining;
		int gteCount = 0;
		while(node != null) {
			if(node.getValue() >= pivot) {
				gteCount++;
			}
			node = node.getNext();
		}
		
		if(gteCount < 2) {
			return;
		}
		
		node = beggining;
		
		
		while(gteCount > 0) {
			LinkedListNode<Integer> current = null;
			while(node != null) {
				if(current == null) {
					if(node.getValue() >= pivot) {
						if(node.getNext() == null) {
							System.out.println("null");
							continue;
						}
						current = new LinkedListNode<Integer>(node.getValue());;
						current.setNext(null);
						
						node.setValue(node.getNext().getValue());
						node.setNext(node.getNext().getNext());
					}
					node = node.getNext();
					continue;
				}
				
				
				if(node.getNext() == null) {
					node.setNext(current);
					break;
				}
				node = node.getNext();
			}
			node = beggining;
			gteCount--;
		}
	}
}
