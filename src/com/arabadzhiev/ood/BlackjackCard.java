package com.arabadzhiev.ood;

public class BlackjackCard extends Card {

	public BlackjackCard(Rank rank, Suit suit) {
		super(rank, suit);
	}
	
	public int getValue(){
		if(this.getRank().equals(Rank.ACE)) {
			return 1;
		}else {
			return this.getRank().getValue();
		}
	}
}
