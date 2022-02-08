package com.arabadzhiev.snq;

import com.arabadzhiev.collections.Queue;

public class ShelterQueue {
	
	Queue<String> all;
	Queue<String> cats;
	Queue<String> dogs;
	
	public ShelterQueue() {
		all = new Queue<>();
		cats = new Queue<>();
		dogs = new Queue<>();
	}
	
	public void enqueue(String name, Animal animal) {
		if(animal.equals(Animal.DOG)) {
			dogs.add(name);
		}else {
			cats.add(name);
		}
		
		all.add(name);
	}
	
	public String dequeueAny() {
		
		if(all.peek().equals(dogs.peek())) {
			dogs.remove();
		}
		
		return all.remove();
	}
	
	public String dequeueDog() {
		Queue<String> tmp = new Queue<>();
		boolean instanceFound = false;
		while(!all.isEmpty()) {
			String dog = all.remove();
			if(!instanceFound && all.peek().equals(dog)) {
				instanceFound = true;
				continue;
			}
			tmp.add(dog);
		}
		
		while(!tmp.isEmpty()) {
			all.add(tmp.remove());
		}
		
		return dogs.remove();
	}
	
	public String dequeueCat() {
		Queue<String> tmp = new Queue<>();
		boolean instanceFound = false;
		while(!all.isEmpty()) {
			String cat = all.remove();
			if(!instanceFound && cat.equals(cats.peek())) {
				instanceFound = true;
				continue;
			}
			tmp.add(cat);
		}
		
		while(!tmp.isEmpty()) {
			all.add(tmp.remove());
		}
		
		return cats.remove();
	}
	
	public static enum Animal{
		DOG,
		CAT
	}
}
