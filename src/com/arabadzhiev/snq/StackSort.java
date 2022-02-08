package com.arabadzhiev.snq;

import com.arabadzhiev.collections.Stack;

public class StackSort {
	
	public static void sortStack(Stack<Integer> stack) {
		if(stack.isEmpty()) {
			return;	
		}
		
		Stack<Integer> tmp = new Stack<>();
		int length = 0;
		
		while(!stack.isEmpty()) {
			tmp.push(stack.pop());
			length++;
		}
		
		Integer carrier = null;
		boolean tmpNext = true;
		while(length > 0) {
			Integer biggest = null;
			boolean biggestSkipped = false;
			if(tmpNext) {
				while(!tmp.isEmpty()) {
					Integer current = tmp.pop();
					if(carrier == current && !biggestSkipped) {
						biggestSkipped = true;
						continue;
					}
					if(biggest == null || biggest < current) {
						biggest = current;
					}
					stack.push(current);
				}
				if(carrier != null) {
					length--;
				}
				carrier = biggest;
				tmpNext = false;
			}else {
				for(int i = 0; i < length; i++) {
					Integer current = stack.pop();
					if(carrier == current && !biggestSkipped) {
						biggestSkipped = true;
						continue;
					}
					if(biggest == null || biggest < current) {
						biggest = current;
					}
					tmp.push(current);
				}
				
				stack.push(carrier);
				stack.push(biggest);
				carrier = biggest;
				length--;
				tmpNext = true;
			}
		}
	}
}
