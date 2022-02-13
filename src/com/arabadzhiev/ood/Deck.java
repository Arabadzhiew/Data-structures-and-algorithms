package com.arabadzhiev.ood;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;


public class Deck <T extends Card> implements Iterable<T>{
	private Stack<T> cards;
	
	public Deck() {
		cards = new Stack<>();
	}
	
	
	public T getNext() {
		if(!isEmpty()) {
			return cards.pop();
		}
		return null;
	}
	
	public void shuffle() {
		LinkedList<T> tmp = new LinkedList<>();
		while(!cards.isEmpty()) {
			tmp.push(cards.pop());
		}
		
		Random rnd = new Random();
		while(!tmp.isEmpty()) {
			cards.push(tmp.remove(Math.abs(rnd.nextInt()) % tmp.size()));
		}
	}
	
	public void setDeckOfCards(Stack<T> cards) {
		if(this.cards.size() != 0) {
			this.cards.removeAllElements();
		}
		for(T card : cards) {
			this.cards.push(card);
		}
	}
	
	public boolean isEmpty() {
		return cards.isEmpty();
	}


	@Override
	public Iterator<T> iterator() {
		return new DeckIterator();
	}
	
	private class DeckIterator implements Iterator<T>{

		@Override
		public boolean hasNext() {
			return !isEmpty();
		}

		@Override
		public T next() {
			return getNext();
		}
		
	}
	
}
