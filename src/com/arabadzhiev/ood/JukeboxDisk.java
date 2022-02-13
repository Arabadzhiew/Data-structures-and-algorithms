package com.arabadzhiev.ood;

public class JukeboxDisk implements Input{

	private String content;
	
	public JukeboxDisk(String content) {
		this.content = content;
	}
	
	@Override
	public String getContent() {
		return content;
	}

}
