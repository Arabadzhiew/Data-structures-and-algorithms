package com.arabadzhiev.algorithms.linkedLists;

import com.arabadzhiev.collections.LinkedListNode;

public class Palindrome {
	public static <T> boolean isPalindrome(LinkedListNode<T> node) {
		int endCounter = -1;
		
		LinkedListNode<T> first = node; 
		while(node != null) {
			endCounter++;
			node = node.getNext();
		}
		
		node = first;
		
		int beginCounter = 0;
		
		while(endCounter > beginCounter) {
			LinkedListNode<T> compareNode = first;
			int loopCounter = 0;
			while(loopCounter < endCounter) {
				compareNode = compareNode.getNext();
				loopCounter++;
			}
			if(!node.getValue().equals(compareNode.getValue())) {
				return false;
			}
			
			beginCounter++;
			endCounter--;
			node = node.getNext();
		}
		
		return true;
	}
}
