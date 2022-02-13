package com.arabadzhiev.ood;

import java.util.HashMap;
import java.util.Map;

public class Author {
	private String name;
	private Map<String, Book> books;
	
	public Author(String name) {
		this.name = name;
		books = new HashMap<>();
	}
	
	public void addBook(Book book) {
		books.put(book.getIsbn(), book);
	}
	
	public Book getBook(String isbn) {
		return books.get(isbn);
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean hasBooks() {
		return !books.isEmpty();
	}
}
