package com.arabadzhiev.grandtr;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

import com.arabadzhiev.collections.BinaryTreeNode;
import com.arabadzhiev.collections.TreeNode;

public class Trees {
	public static TreeNode<Integer> arayToBST(int[] array) {
		int middle = array.length / 2;
		TreeNode<Integer> root = new TreeNode<>(array[middle]);
		
		int[] left = new int[middle];
		int[] right = new int[middle - (array.length % 2 == 0 ? 1 : 0)];
		
		for(int i = 0; i < middle; i++) {
			left[i] = array[i];
		}
		
		for(int i = middle + 1; i < array.length; i++) {
			right[i - middle - 1] = array[i];
		}
		
		
		arrayToBST(root, left);
		arrayToBST(root, right);
		
		return root;
	}
	
	private static void arrayToBST(TreeNode<Integer> node, int[] array) {
		if(array.length == 1) {
			node.addChild(new TreeNode<>(array[0]));
			return;
		}
		
		if(array.length == 0) {
			return;
		}
		
		int middle = array.length / 2;
		
		TreeNode<Integer> child = new TreeNode<>(array[middle]);
		
		int[] left = new int[middle];
		int[] right = new int[middle - (array.length % 2 == 0 ? 1 : 0)];
		
		for(int i = 0; i < middle; i++) {
			left[i] = array[i];
		}
		
		for(int i = middle + 1; i < array.length; i++) {
			right[i - middle - 1] = array[i];
		}
		
		arrayToBST(child, left);
		arrayToBST(child, right);
		
		node.addChild(child);
	}
	
	public static <T> ArrayList<LinkedList<TreeNode<T>>> listOfDepths(TreeNode<T> root){
		ArrayList<LinkedList<TreeNode<T>>> list = new ArrayList<>();
		
		LinkedList<TreeNode<T>> ll = new LinkedList<>();
		ll.add(root);
		list.add(ll);
		
		listOfDepths(list, root.getChildren().get(0), 1);
		listOfDepths(list, root.getChildren().get(1), 1);
		
		return list;
	}
	
	private static <T> void listOfDepths(ArrayList<LinkedList<TreeNode<T>>> list, TreeNode<T> current, int depth) {
		if(current == null) {
			return;
		}
		
		if(list.size() < depth + 1) {
			list.add(new LinkedList<>());
		}
		
		list.get(depth).add(current);
		
		listOfDepths(list, current.getChildren().get(0), depth + 1);
		listOfDepths(list, current.getChildren().get(1), depth + 1);
	}
	
	public static <T> boolean isBalanced(TreeNode<T> root) {
		int heigthLeft = getHeight(root.getChildren().get(0));
		int heigthRight = getHeight(root.getChildren().get(1));
		
		System.out.println(Math.abs(heigthLeft - heigthRight));
		
		return Math.abs(heigthLeft - heigthRight) <= 1;
	}
	
	private static <T> int getHeight(TreeNode<T> root) {
		
		if(root == null) {
			return 0;
		}
		
		int height = 1;
		
		ArrayList<TreeNode<T>> parents = new ArrayList<>();
		parents.add(root);
		
		while(!parents.isEmpty()) {
			boolean incremented = false;
			ArrayList<TreeNode<T>> next = new ArrayList<>();
			for(TreeNode<T> n : parents) {
				if(n.getChildren().get(0) != null) {
					next.add(n.getChildren().get(0));
					if(!incremented) {
						height++;
						incremented = true;
					}
				}
				
				if(n.getChildren().get(1) != null) {
					next.add(n.getChildren().get(1));
					if(!incremented) {
						height++;
						incremented = true;
					}
				}
			}
			parents = next;
		}
		
		return height;
	}
	
	public static boolean isBST(TreeNode<Integer> root) {
		if(root == null) {
			return true;
		}
		
		if(root.getChildren().get(0) == null && root.getChildren().get(1) == null) {
			return true;
		}
		ArrayList<Integer> inOrderElements = new ArrayList<>();
		
		inOrderTraversal(root, inOrderElements);
		
		System.out.println(inOrderElements.get(0));
		for(int i = 1; i < inOrderElements.size(); i++){
			System.out.println(inOrderElements.get(i));
			if(inOrderElements.get(i - 1) > inOrderElements.get(i)) {
				return false;
			}
		}
		return true;
	}
	
	private static void inOrderTraversal(TreeNode<Integer> node, ArrayList<Integer> storage) {
		
		if(node.getChildren().get(0) != null) {
			inOrderTraversal(node.getChildren().get(0), storage);
		}
		
		storage.add(node.getValue());
		
		if(node.getChildren().get(1) != null) {
			inOrderTraversal(node.getChildren().get(1), storage);
		}
	}
	
	public static <T> TreeNode<T> inorderSuccesor(TreeNode<T> n){
		if(n == null) {
			return null;
		}
		
		if(n.getChildren().get(1) != null) {
			return leftMostChild(n.getChildren().get(1));
		}else {
			TreeNode<T> q = n;
			TreeNode<T> x = q.getParent();
			
			while(x != null && x.getChildren().get(0) != q) {
				q = x;
				x = x.getParent();
			}
			return x;
		}
		
	}
	
	private static <T> TreeNode<T> leftMostChild(TreeNode<T> n) {
		if(n == null) {
			return null;
		}
		
		while(n.getChildren().get(0) != null) {
			n = n.getChildren().get(0);
		}
		return n;
	}
	
	public static <T> BinaryTreeNode<T> findFirstAncestor(BinaryTreeNode<T> first, BinaryTreeNode<T> second){
		
		BinaryTreeNode<T> root = first;
		
		while(root.getParent() != null) {
			root = root.getParent();
		}
		
		BinaryTreeNode<T> left = root.getLeft();
		BinaryTreeNode<T> right = root.getRight();
		boolean ancestorFound = false;
		while(!ancestorFound) {
			if(rootContains(left, first) && rootContains(left, second)) {
				root = left;
				left = root.getLeft();
				right = root.getRight();
				continue;
			}
			if(rootContains(right, first) && rootContains(right, second)) {
				root = right;
				left = root.getLeft();
				right = root.getRight();
				continue;
			}
			
			
			ancestorFound = true;
		}
		
		
		return root;
	}
	
	private static <T> boolean rootContains(BinaryTreeNode<T> root, BinaryTreeNode<T> searched) {
		
		if(root.equals(searched)) {
			return true;
		}
		
		Stack<BinaryTreeNode<T>> stack = new Stack<>();
		if(root.getRight() != null) {
			stack.push(root.getRight());
		}
		if(root.getLeft() != null) {
			stack.push(root.getLeft());
		}
		
		while(!stack.isEmpty()) {
			BinaryTreeNode<T> current = stack.pop();
			
			if(current.equals(searched)) {
				return true;
			}
			
			if(current.getRight() != null) {
				stack.push(current.getRight());
			}
			if(current.getLeft() != null) {
				stack.push(current.getLeft());
			}
		}
		
		return false;
	}
	
	public static <T> boolean isSubtreeOf(BinaryTreeNode<T> t2, BinaryTreeNode<T> t1) {
		
		BinaryTreeNode<T> queried = findEqual(t2, t1);
		
		if(queried == null) {
			return false;
		}
		
		LinkedList<BinaryTreeNode<T>> queue1 = new LinkedList<>();
		LinkedList<BinaryTreeNode<T>> queue2 = new LinkedList<>();
		
		queue1.add(queried);
		queue2.add(t2);
		
		while(!queue1.isEmpty() && !queue2.isEmpty()) {
			BinaryTreeNode<T> pop1 = queue1.pop();
			BinaryTreeNode<T> pop2 = queue2.pop();
			if(!pop1.getValue().equals(pop2.getValue())) {
				return false;
			}
			
			if(pop1.getLeft() != null) {
				queue1.push(pop1.getLeft());
			}
			if(pop1.getRight() != null) {
				queue1.push(pop1.getRight());
			}
			if(pop2.getLeft() != null) {
				queue2.push(pop2.getLeft());
			}
			if(pop2.getRight() != null) {
				queue2.push(pop2.getRight());
			}
		}
		
		if(queue1.isEmpty() && queue2.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public static <T> BinaryTreeNode<T> findEqual(BinaryTreeNode<T> searched, BinaryTreeNode<T> root){
		if(root == null) {
			return null;
		}
		
		if(root.getValue().equals(searched.getValue())) {
			return root;
		}
		
		BinaryTreeNode<T> left = findEqual(searched, root.getLeft());
		BinaryTreeNode<T> right = findEqual(searched, root.getRight());
		
		
		if(left != null) {
			return left;
		}
		
		return right;
	}
	
	public static int pathsToSum(BinaryTreeNode<Integer> root, int sum) {
		if(root == null) {
			return 0;
		}
		
		int pathsFromRoot = pathsToSum(root.getLeft(), sum , root.getValue()) 
				+ pathsToSum(root.getRight(), sum, root.getValue());
		
		int pathsFromLeft = pathsToSum(root.getLeft(), sum);
		int pathsFromRight = pathsToSum(root.getRight(), sum);
		
		return pathsFromRoot + pathsFromLeft + pathsFromRight;
		
		
//		return pathsToSum(root.getLeft(), sum, root.getValue()) + pathsToSum(root.getRight(), sum, root.getValue());
	}
	
	private static int pathsToSum(BinaryTreeNode<Integer> root, int sum, int current) {
		if(root == null) {
			return 0;
		}
		
		int sums = 0;
		current += root.getValue();
		
		if(current == sum) {
			sums++;
		}
		
		sums += pathsToSum(root.getLeft(), sum, current);
		sums += pathsToSum(root.getRight(), sum, current);
		
		return sums;
	}
	
}
