package com.arabadzhiev.ood;

public class Card {
	
	private Suit suit;
	private Rank rank;
	
	public static Card createCard(Rank rank, Suit suit) {
		return new Card(rank, suit);
	}
	
	public Card(Rank rank, Suit suit) {
		this.suit = suit;
		this.rank = rank;
	}
	
	public Suit getSuit() {
		return this.suit;
	}
	
	public Rank getRank() {
		return this.rank;
	}
	
	
	public static enum Suit{
		CLUB,
		DIAMOND,
		HEARTH,
		SPADE
	}
	
	public static enum Rank{
		ACE(11),
		KING(10),
		QUEEN(10),
		JACK(10),
		TEN(10),
		NINE(9),
		EIGHT(8),
		SEVEN(7),
		SIX(6),
		FIVE(5),
		FOUR(4),
		THREE(3),
		TWO(2);
		
		private int value;
		
		Rank(int value) {
			this.value = value;
		}
		
		public int getValue() {
			return this.value;
		}
	}
}
