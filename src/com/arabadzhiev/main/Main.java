package com.arabadzhiev.main;

import com.arabadzhiev.collections.HashMap;

public class Main {
	
	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<>();
		
		map.add(1, "turciq");
		map.add(2, "bulgaria");
		map.add(122, "uk");
		map.add(-10, "us");
		map.add(222, "bangladesh");
		map.add(123, "india");
		map.add(1111, "pakistani");
		map.add(2, "abu dabi");
		map.add(122, "romaina");
		
		System.out.println(map.contains(1));
		System.out.println(map.contains(2));
		System.out.println(map.contains(3));
		System.out.println(map.contains(122));
		System.out.println();
		
		for(String s : map) {
			System.out.println(s);
		}
	}
}
