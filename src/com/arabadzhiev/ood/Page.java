package com.arabadzhiev.ood;

public class Page {
	
	private int id;
	private String heading;
	private String body;
	
	public Page(int id, String heading, String body) {
		this.id = id;
		this.heading = heading;
		this.body = body;
	}
	
	public String getHeading() {
		return heading;
	}
	public void setHeading(String header) {
		this.heading = header;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public int getId() {
		return id;
	}
	
	
}
