package com.arabadzhiev.ood;

public class Jukebox implements MusicPlayer{
	
	private Input in;
	
	@Override
	public void insert(Input in) {
		if(this.in == null) {
			this.in = in;
		}else {
			System.out.println("Remove the current disk to insert a new one.");
		}
		
	}

	@Override
	public void play() {
		System.out.println(in.getContent());
		
	}

	@Override
	public void stop() {
		// stop the current playing thread, if there is one
		
	}

	@Override
	public Input remove() {
		Input current = this.in;
		this.in = null;
		return current;
	}
	
}
