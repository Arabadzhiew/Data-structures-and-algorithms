package com.arabadzhiev.main;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

import com.arabadzhiev.algorithms.arrays.Array;
import com.arabadzhiev.bitman.BinaryInsertion;
import com.arabadzhiev.bitman.BitsToSwap;
import com.arabadzhiev.bitman.DoublePrintBinary;
import com.arabadzhiev.bitman.LargestAndSmallest;
import com.arabadzhiev.bitman.LinearBitSwap;
import com.arabadzhiev.bitman.MaxBitSequence;
import com.arabadzhiev.bitman.MonochromeScreen;
import com.arabadzhiev.collections.BinaryTreeNode;
import com.arabadzhiev.collections.Graph;
import com.arabadzhiev.collections.Graph.Node;
import com.arabadzhiev.collections.LinkedListNode;
import com.arabadzhiev.collections.Listy;
import com.arabadzhiev.collections.TreeNode;
import com.arabadzhiev.grandtr.Graphs;
import com.arabadzhiev.grandtr.Graphs.Project;
import com.arabadzhiev.grandtr.MaxBinaryTreeWidth;
import com.arabadzhiev.grandtr.RandomBinarySearchTree;
import com.arabadzhiev.grandtr.Trees;
import com.arabadzhiev.lambda.Country;
import com.arabadzhiev.lambda.RandomSubset;
import com.arabadzhiev.math.Apocalypse;
import com.arabadzhiev.minesweeper.Board;
import com.arabadzhiev.minesweeper.Game;
import com.arabadzhiev.minesweeper.MineCell;
import com.arabadzhiev.ood.Call;
import com.arabadzhiev.ood.CallCenter;
import com.arabadzhiev.ood.Car;
import com.arabadzhiev.ood.Card;
import com.arabadzhiev.ood.Deck;
import com.arabadzhiev.ood.Director;
import com.arabadzhiev.ood.HashTable;
import com.arabadzhiev.ood.Jukebox;
import com.arabadzhiev.ood.JukeboxDisk;
import com.arabadzhiev.ood.Manager;
import com.arabadzhiev.ood.MusicPlayer;
import com.arabadzhiev.ood.Respondent;
import com.arabadzhiev.recursion.Cents;
import com.arabadzhiev.recursion.Fill;
import com.arabadzhiev.recursion.Hanoi;
import com.arabadzhiev.recursion.MagicIndex;
import com.arabadzhiev.recursion.Mathematics;
import com.arabadzhiev.recursion.Parentheses;
import com.arabadzhiev.recursion.PowerSet;
import com.arabadzhiev.recursion.RobotGrid;
import com.arabadzhiev.recursion.Staircase;
import com.arabadzhiev.recursion.StringPermutations;
import com.arabadzhiev.sortandsearch.Anagrams;
import com.arabadzhiev.sortandsearch.BinarySearch;
import com.arabadzhiev.sortandsearch.FindDuplicates;
import com.arabadzhiev.sortandsearch.ListySearch;
import com.arabadzhiev.sortandsearch.MatrixSearch;
import com.arabadzhiev.sortandsearch.MatrixSearch.Location;
import com.arabadzhiev.sortandsearch.Merge;
import com.arabadzhiev.sortandsearch.PeaksAndValleys;
import com.arabadzhiev.sortandsearch.RotatedSearch;
import com.arabadzhiev.sortandsearch.SparseSearch;
import com.arabadzhiev.threads.A;
import com.arabadzhiev.threads.FizzBuzz;
import com.arabadzhiev.threads.OrderCall;
import com.arabadzhiev.ood.Card.Rank;
import com.arabadzhiev.ood.Card.Suit;
import com.arabadzhiev.ood.CircularArray;

public class Main {
	
	public static void main(String[] args){
		
		
		int[] array = {3,1,6,1,7,2,3,3, -1, 10, 11, 5, 8 , 9, 4 , 0};
		
		long before = System.nanoTime();
		
		Array.quickSort(array);
		
		long after = System.nanoTime();
		
		System.out.println("Execution time: " + (after - before) + "ns\n");
		
		Arrays.stream(array)
			.forEach(num -> System.out.println(num));
		
		
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
	
	public static <T> void invertBT(BinaryTreeNode<T> head) {
		if(head == null) {
			return;
		}
		
		BinaryTreeNode<T> tmp = head.getLeft();
		
		head.setLeft(head.getRight());
		head.setRight(tmp);
		
		invertBT(head.getLeft());
		invertBT(head.getRight());
	}
	
//	public static <T> void reverseLL(LinkedListNode<T> head) {
//		Stack<T> stack = new Stack<>();
//		
//		LinkedListNode<T> tmp = head;
//		
//		while(tmp != null) {
//			stack.push(tmp.getValue());
//			tmp = tmp.getNext();
//		}
//		
//		while(!stack.isEmpty()) {
//			head.setValue(stack.pop());
//			head = head.getNext();
//		}
//	}
	
	public static <T> LinkedListNode<T> reverseLL(LinkedListNode<T> head){
		if(head == null) {
			return null;
		}
		
		LinkedListNode<T> previous = null;
		while(head.getNext() != null) {
			
			LinkedListNode<T> next = head.getNext();
			head.setNext(previous);
			
			previous = head;
			head = next;
		}
		head.setNext(previous);
		
		
		return head;
	}
	
	public static <T> LinkedListNode<T> reverseLLRecursive(LinkedListNode<T> head){
		if(head == null) {
			return null;
		}else if(head.getNext() == null) {
			return head;
		}
		
		return reverseLLRecursive(null, head);
		
	}
	
	public static <T> LinkedListNode<T> reverseLLRecursive(LinkedListNode<T> previous,LinkedListNode<T> head){
		if(head.getNext() == null) {
			head.setNext(previous);
			return head;
		}
		
		LinkedListNode<T> next = head.getNext();
		
		head.setNext(previous);
		
		return reverseLLRecursive(head, next);
	}
	
	public static String reverseString(String s) {
		if(s == null || s.length() < 2) {
			return s;
		}
		
		StringBuilder sb = new StringBuilder();
		reverseString(s, sb, 0);
		
		return sb.toString();
	}
	private static void reverseString(String s, StringBuilder sb, int index) {
		if(index + 1 == s.length()) {
			sb.append(s.charAt(index));
			return;
		}
		
		char current = s.charAt(index);
		
		reverseString(s, sb, index + 1);
		
		sb.append(current);
	}
	
	public static <T> void reverseArray(T[] array) {
		for(int i = 0; i < array.length / 2; i++) {
			T tmp = array[i];
			array[i] = array[array.length - i - 1];
			array[array.length - i - 1] = tmp;
		}
	}
	
	public static <T> void reverseArrayRecursively(T[] array) {
		if(array == null || array.length < 2) {
			return;
		}
		 reverseArrayRecursively(array,  0);
	}
	
	private static <T> void reverseArrayRecursively(T[] array, int index) {
		if(index == array.length) {
			return;
		}
		
		T current = array[index];
		
		reverseArrayRecursively(array, index + 1);
		
		array[array.length - index - 1] = current;
	}
	
	public static long fibonacci(int n) {
		return fibonacci(n, new long[n + 1]);
	}
	
	public static long fibonacci(int n, long[] pastSeqs) {
		if(n == 0) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}
		
		if(pastSeqs[n] == 0) {
			pastSeqs[n] = fibonacci(n - 1, pastSeqs) + fibonacci(n - 2, pastSeqs);
		}
		
		return pastSeqs[n];
	}
	
	public static <T> LinkedListNode<T> reverseLinkedList(LinkedListNode<T> head){
		
		if(head == null) {
			return null;
		}
		
		LinkedListNode<T> previous = null;
		
		while(head.getNext() != null) {
			LinkedListNode<T> next = head.getNext();
			
			head.setNext(previous);
			
			previous = head;
			head = next;
		}
		
		head.setNext(previous);
		
		return head;
	}
}
