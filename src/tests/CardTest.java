package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.Card;

public class CardTest {

	@Test
	public void testConstructor() {
		Card firstCard = new Card(2,1);
		assertEquals("Incorrect card constructor or getters", "2 of Spades", 
				firstCard.getNumber() + " of " + firstCard.getSuit());
	}

}
