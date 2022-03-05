package com.arabadzhiev.recursion;

import java.util.Stack;

public class Hanoi {
	public static void moveDisks(Stack<Integer> first, Stack<Integer> buffer, Stack<Integer> destination, int disks){
		
		if(disks == 0) {
			return;
		}
		
		moveDisks(first, destination, buffer, disks - 1);
		destination.push(first.pop());
		moveDisks(buffer, first, destination, disks - 1);
		
	}
}
