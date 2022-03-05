package com.arabadzhiev.math;


public class Apocalypse {
	
	public static void genderDistibution(int families) {
		int boys = 0;
		int girls = 0;
		int total = 0;
		int boysRecord = 0;
		for(int i = 0; i < families; i++) {
			long gender = System.nanoTime() % 2;
			
			int familyBoys = 0;
			while(gender == 0) {
				familyBoys++;
				boys++;
				total++;
				gender = System.nanoTime() % 2;
			}
			
			if(familyBoys > boysRecord) {
				boysRecord = familyBoys;
			}
			girls++;
			total++;
		}
		
		System.out.println("Distribution in percents : " + (boys * 100 / total) + "% boys, " + (girls * 100 / total) + "% girls.");
		System.out.println("The familly with the biggest count of boys has: " + boysRecord + " boys.");
	}
}
