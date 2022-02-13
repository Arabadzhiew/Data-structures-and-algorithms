package com.arabadzhiev.ood;

public class Book {
	
	private Author author;
	private Publisher publisher;
	private String isbn;
	private Page[] pages;
	private int length;
	
	public Book(Author author, Publisher publisher, String isbn, Page[] pages) {
		this.author = author;
		this.publisher = publisher;
		this.isbn = isbn;
		this.pages = pages;
		this.length = pages.length;
	}

	public Author getAuthor() {
		return author;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public String getIsbn() {
		return isbn;
	}

	public Page[] getPages() {
		return pages;
	}

	public int getLength() {
		return length;
	}
	
	
}
