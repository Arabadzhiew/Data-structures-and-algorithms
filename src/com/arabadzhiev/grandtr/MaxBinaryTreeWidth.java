package com.arabadzhiev.grandtr;

import java.util.LinkedList;
import java.util.Queue;

public class MaxBinaryTreeWidth {
	
	public static  int widthOfBinaryTree(TreeNode root) {
        LinkedList<TreeNode> main = new LinkedList<>();
        LinkedList<TreeNode> secondary = new LinkedList<>();
        TreeNode empty = new TreeNode();
        
        main.push(root);
        boolean reachedBottom = true;
        int maxWidth = 0;
        
        do {
        	 reachedBottom = true;
        	 if(main.isEmpty()) {
         		break;
         	}
        	 while(main.peekLast() == empty){
                 main.pollLast();
             }
        	 
        	 while(main.peek() == empty){
                 main.poll();
             }
             
             int levelWidth = 0;
             
             
             while(!main.isEmpty()) {
             	TreeNode poped = main.pollLast();
             	
             	if(poped != empty) {
             		reachedBottom = false;
             	}
             	
             	levelWidth++;
                 
                
             	 if(poped.left == null) {
                  	secondary.push(empty);
                 }else {
                  	secondary.push(poped.left);
                 }
             	
                 if(poped.right == null) {
                 	secondary.push(empty);
                 }else {
                 	secondary.push(poped.right);
                 }
                 
             }
             
             
             if(levelWidth > maxWidth) {
            	 maxWidth = levelWidth;
             }
             
             LinkedList<TreeNode> tmp = main;
             main = secondary;
             secondary = tmp;
        }while(!reachedBottom);
        
        
        return maxWidth;
    }
	
	public static int optimizedWidthOfBinaryTree(TreeNode root) {
		
		if(root.left == null || root.right == null) {
			return 1;
		}
		
		Queue<TreeNode> main = new LinkedList<>();
		Queue<TreeNode> secondary = new LinkedList<>();
		
		Queue<Integer> values = new LinkedList<>();
		
		main.offer(root);
		values.offer(0);
		
		int treeMax = 0;
		
		while(!main.isEmpty()) {
			
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			
			while(!main.isEmpty()) {
				
				TreeNode polled = main.poll();
				Integer value = values.poll();
				
				
				if(value < min) {
					min = value;
				}
				
				if(value > max) {
					max = value;
				}
				
				if(polled.left != null) {
					secondary.offer(polled.left);
					values.offer(value * 2 + 1);
				}
				
				if(polled.right != null) {
					secondary.offer(polled.right);
					values.offer(value * 2 + 2);
				}
				
				int levelMax = max - min + 1;
				
				
				if(levelMax > treeMax) {
					treeMax = levelMax;
				}
				
			}
			
			Queue<TreeNode> tmp = main;
			main = secondary;
			secondary = tmp;
			
		}
		
		return treeMax;
	}
	
	
	 public static class TreeNode {
	 	int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode() {}
		public TreeNode(int val) { this.val = val; }
		public TreeNode(int val, TreeNode left, TreeNode right) {
	 		this.val = val;
	 		this.left = left;
	 		this.right = right;
	 	}
	 }
	 
}
