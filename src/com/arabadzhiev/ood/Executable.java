package com.arabadzhiev.ood;

public class Executable extends Entity{
	
	public final int KB = 1024;
	public final int MB = KB * 1024;
	public final int GB = MB * 1024;
	
	private byte[] content;
	private long size;
	
	
	public Executable(String name, Folder parent,byte[] content) {
		super(name, parent);
		this.content = content;
		this.size = content.length;
	}

	public byte[] getContent() {
		return content;
	}

	public long getSizeKB() {
		return size / KB;
	}
	
	public long getSizeMB() {
		return size / MB;
	}
	
	public long getSizeGB() {
		return size / GB;
	}
	
}
