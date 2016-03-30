package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.Card;
import poker.Deck;

public class DeckTest {
	Deck cardDeck;
	
	@Test
	public void testShuffle() {
		cardDeck = new Deck();
		Deck oldDeck = cardDeck;
		
		cardDeck.shuffle();
		
		assertEquals("Incorrect size for card deck after shuffle", oldDeck.getCardCount(), cardDeck.getCardCount());
		boolean same = true;
		for(int i = 0; i < cardDeck.getCardCount(); i++){
			if(!(oldDeck.getCardList().get(i).equals(cardDeck.getCardList().get(i)))){
				same = false;
		}
		assertTrue("Cards in same order", same);
			
		}
	}
	
	@Test
	public void testDealOneCardEmpty() {
			cardDeck = new Deck();
			int count = cardDeck.getCardCount();
			
			for(int i = 0; i < count; i++){
	        	cardDeck.dealOneCard();
        	}
			assertNull("Null card not returned", cardDeck.dealOneCard());
	}
	
	@Test
	public void testDealOneCard() {
			cardDeck = new Deck();
			Card topCard = cardDeck.getCardList().get(0);
			assertEquals("Incorrect card dealt", topCard, cardDeck.dealOneCard());

	}
	
	@Test
	public void testConstructor() {
		Deck newDeck = new Deck();
		
		assertEquals("Incorrect size for card deck", newDeck.getCardCount(), 52);	
	}


}
