package com.arabadzhiev.main;



import com.arabadzhiev.algorithms.linkedLists.*;
import com.arabadzhiev.collections.*;

public class Main {
	
	public static void main(String[] args){
		
		long before = System.nanoTime();
		
		LinkedListNode<String> node = new LinkedListNode<>("A");
		node.setNext(new LinkedListNode<>("B"));
		node.getNext().setNext(new LinkedListNode<>("C"));
		node.getNext().getNext().setNext(new LinkedListNode<>("D"));
		node.getNext().getNext().getNext().setNext(new LinkedListNode<>("E"));
		LinkedListNode<String> loop = node.getNext().getNext();
//		node.getNext().getNext().getNext().getNext().setNext(loop);
		node.getNext().getNext().getNext().getNext().setNext(new LinkedListNode<>("F"));
		
		
		try {
			System.out.println(LoopDetection.findLoop(node).getValue());
		}catch(NullPointerException e) {
			System.out.println("null");
		}

				
		long after = System.nanoTime();
		
		System.out.println("\n" + (after - before));
	}
	
	public static void printMatrix(int[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				System.out.print(" " + matrix[i][j]);
			}
			System.out.println();
		}
	}
}
