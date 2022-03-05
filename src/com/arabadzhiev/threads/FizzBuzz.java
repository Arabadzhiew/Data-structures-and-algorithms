package com.arabadzhiev.threads;

import java.util.concurrent.Semaphore;

public class FizzBuzz {
	private volatile int current;
	
	private Semaphore numSem;
	private Semaphore fizzSem;
	private Semaphore buzzSem;
	private Semaphore fizzBuzzSem;
	
	public FizzBuzz() {
		numSem = new Semaphore(1);
		fizzSem = new Semaphore(0);
		buzzSem = new Semaphore(0);
		fizzBuzzSem = new Semaphore(0);
		
	}
	
	public void fizzBuzz(int n) {
		current = 0;
		Runnable num = ()->{
			while(current < n) {
				try {
					numSem.acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				current++;
				System.out.print(current);
				fizzBuzzSem.release();
			}
			fizzBuzzSem.release();
			fizzSem.release();
			buzzSem.release();
		};
		
		Runnable fizz = ()->{
			while(current < n) {
				try {
					fizzSem.acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(current % 3 == 0) {
					System.out.println(" Fizz");
					numSem.release();
				}else {
					buzzSem.release();
				}
			}
		};
		
		Runnable buzz = ()->{
			while(current < n) {
				try {
					buzzSem.acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(current % 5 == 0) {
					System.out.println(" Buzz");
				}else {
					System.out.println();
				}
				numSem.release();
			}
		};
		
		Runnable fizzBuzz = ()->{
			while(current < n) {
				try {
					fizzBuzzSem.acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(current % 3 == 0 && current % 5 == 0) {
					System.out.println(" FizzBuzz");
					numSem.release();
				}else {
					fizzSem.release();
				}
			}
		};
		
		Thread t1 = new Thread(num);
		Thread t2 = new Thread(fizz);
		Thread t3 = new Thread(buzz);
		Thread t4 = new Thread(fizzBuzz);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
