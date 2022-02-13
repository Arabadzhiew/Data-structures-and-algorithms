package com.arabadzhiev.ood;

import java.util.LinkedList;

public class CallCenter {
	
	private LinkedList<Employee> employees;
	private int respondentCount;
	private int managerCount;
	private int directorCount;
	
	public CallCenter() {
		this.employees = new LinkedList<>();
		this.respondentCount = 0;
		this.managerCount = 0;
		this.directorCount = 0;
	}
	
	public void dispatchCall(Call c) {
		for(int i = 0; i < respondentCount; i++) {
			Employee e = employees.get(i);
			if(e.getSkillLevel() >= c.getDifficulty()) {
				System.out.println(e.getClass().getSimpleName()  + " " + e.getName() + " handeled call");
				return;
			}
		}
		
		for(int i = respondentCount; i < respondentCount + managerCount; i++) {
			Employee e = employees.get(i);
			if(e.getSkillLevel() >= c.getDifficulty() && e.isFree()) {
				System.out.println(e.getClass().getSimpleName() + " " + e.getName() + " handeled call");
				return;
			}
		}
		
		for(int i = respondentCount + managerCount; i < respondentCount + managerCount + directorCount; i++) {
			Employee e = employees.get(i);
			if(e.getSkillLevel() >= c.getDifficulty()) {
				System.out.println(e.getClass().getSimpleName()  + " " + e.getName() + " handeled call");
				return;
			}
		}
	}
	
	public void addRespondent(Respondent r) {
		this.employees.add(respondentCount, r);
		respondentCount++;
	}
	
	public void addManager(Manager m ) {
		this.employees.add((respondentCount + managerCount), m);
		managerCount++;
	}
	
	public void addDirector(Director d) {
		this.employees.add((respondentCount + managerCount + directorCount), d);
		directorCount++;
	}
	
}
