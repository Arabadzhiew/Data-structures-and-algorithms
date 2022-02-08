package com.arabadzhiev.main;

import java.util.ArrayList;
import java.util.LinkedList;

import com.arabadzhiev.collections.BinaryTreeNode;
import com.arabadzhiev.collections.Graph;
import com.arabadzhiev.collections.Graph.Node;
import com.arabadzhiev.collections.TreeNode;
import com.arabadzhiev.grandtr.Graphs;
import com.arabadzhiev.grandtr.Graphs.Project;
import com.arabadzhiev.grandtr.RandomBinarySearchTree;
import com.arabadzhiev.grandtr.Trees;

public class Main {
	
	public static void main(String[] args){
		
		long before = System.nanoTime();
		
		RandomBinarySearchTree tree = new RandomBinarySearchTree(5);
		tree.insert(2);
		tree.insert(7);
		tree.insert(9);
		tree.insert(-1);
		tree.insert(1);
		tree.insert(8);
		tree.insert(-2);
		
		System.out.println(Trees.pathsToSum(tree.getRoot(), -1));
		
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
	
	public static <T> void printTree(TreeNode<T> node) {
		TreeNode<T> left = node.getChildren().get(0);
		TreeNode<T> right = node.getChildren().get(1);
		if(left != null) {
			printTree(left);
		}
		System.out.println(node.getValue());
		if(right != null) {
			printTree(right);;
		}
	}
	
	public static <T> void printBinaryTree(BinaryTreeNode<T> node) {
		BinaryTreeNode<T> left = node.getLeft();
		BinaryTreeNode<T> right = node.getRight();
		if(left != null) {
			printBinaryTree(left);
		}
		System.out.println(node.getValue());
		if(right != null) {
			printBinaryTree(right);
		}
		
	}
	
	public static <T> void addParents(TreeNode<T> node) {
		TreeNode<T> left = node.getChildren().get(0);
		TreeNode<T> right = node.getChildren().get(1);
		if(left != null) {
			left.setParent(node);
			addParents(left);
		}
		if(right != null) {
			right.setParent(node);
			addParents(right);
		}
	}
}
