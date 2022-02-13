package com.arabadzhiev.ood;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Publisher implements Iterable<Book>{
	
	private String name;
	private String address;
	private List<Book> books;
	
	public Publisher(String name, String address) {
		this.name = name;
		this.address = address;
		this.books = new ArrayList<>();
	}
	
	public void addBook(Book book) {
		this.books.add(book);
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}

	@Override
	public Iterator<Book> iterator() {
		return new PublisherIterator();
	}
	
	private class PublisherIterator implements Iterator<Book>{
		
		private int index = 0;
		@Override
		public boolean hasNext() {
			return index < books.size();
		}

		@Override
		public Book next() {
			return books.get(index);
		}
		
	}
	
	
}
