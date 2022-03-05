package com.arabadzhiev.threads;

public class A {
	
	private Object key1 = new Object();
	private Object key2 = new Object();
	
	public void a() {
		synchronized(key1) {
			System.out.println("In method A trough thread: " + Thread.currentThread().getName());
			b();
		}
	}
	
	public void b() {
		synchronized(key2) {
			System.out.println("In method B trough thread: " + Thread.currentThread().getName());
			c();
		}
	}
	
	public void c() {
		synchronized(key1) {
			System.out.println("In method C trough thread: " + Thread.currentThread().getName());
		}
	}
}
