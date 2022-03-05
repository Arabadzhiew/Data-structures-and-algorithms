package com.arabadzhiev.threads;

public class OrderCall {
	
	private Object key = new Object();
	
	private volatile boolean firstCalled = false;
	private volatile boolean secondCalled = false;
	
	public void first() {
		synchronized(key) {
			System.out.println("Method first();");
			firstCalled = true;
			key.notify();
		}
	}
	
	public void second() throws InterruptedException {
		synchronized(key) {
			while(!firstCalled) {
				key.wait();
			}
			System.out.println("Method second();");
			secondCalled = true;
			key.notify();
		}
	}
	
	public void third() throws InterruptedException {
		synchronized(key) {
			while(!secondCalled) {
				key.wait();
			}
			System.out.println("Method third();");
			key.notify();
		}
	}
}
