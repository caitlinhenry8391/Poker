package poker;
/**
 * Deck class is an implementation of a standard deck of poker-style playing cards. 
 * Each instance of a deck will contain fifty-two playing cards.
 * The cards will have four suits: hearts,spades, clubs, diamonds and with face values of Ace, 2-10, Jack, Queen, and King.
 * The deck maintains a count of the number of cards currently in the deck.
 * 
 * @author Caitlin Henry
 * @version 1.0
*/

import java.util.ArrayList;
import java.util.Scanner;
	
public class Deck {
	private static int numOfCards;
	private ArrayList<Card> cardList = new ArrayList<Card>(); 
	
	/**
	 * The Deck constructor produces the 52-card deck, with cards in ascending order (Ace high).
	 */
	public Deck(){
		
		//set number of cards to zero
		numOfCards = 0;
		
		//loop through each card face value, create 4 cards with each face value - one in each suit
		for(int i = 2; i < 15; i++){
			for(int j = 1; j < 5; j++){
				Card newCard = new Card(i, j);
				
				//add new card to the deck and increment size counter
				cardList.add(newCard);
				numOfCards++;
			}
		}
	}
	
	/**
	 * Getter method for the card list in the deck.
	 * @return list of cards in deck
	 */
	public ArrayList<Card> getCardList(){
		return cardList;
	}
	
	/**
	 * Getter method for the size of deck.
	 * @return number of cards in deck
	 */
	public int getCardCount(){
		return numOfCards;
	}
	
	/**
	 * Returns a Card from the top of the deck, there are any cards in the deck. 
	 * Top of the deck is defined as the first card in the list of current cards in the deck.
	 * 
	 * @return Card at the top of the deck, or null if cards have already been dealt.
	 */
	public Card dealOneCard(){
		
		//check to see if there are cards left in deck
		if(cardList.size() > 0){
			
			//remove the card from the deck, decrement counter, and return card
			Card returnCard = cardList.remove(0);
			numOfCards--;
			return returnCard;
		}
		
		else return null;
	}
	
	/**
	 * Shuffles all cards in the deck and distributes them randomly throughout the deck. 
	 * Shuffles each card by generating a random number between 1 and the size of the deck, and inserting the card at that position in the deck.
	 */
	public void shuffle(){

		int newOrder;
		
		//make a copy of the list to shuffle
		ArrayList<Card> newCardList = cardList;
		
		//loop through each card to generate new position in deck
		for(int i = 0; i < cardList.size(); i++){
			Card currentCard = cardList.get(i);
			
			//remove the card from its original order in deck
			newCardList.remove(currentCard);
			
			//generate random number between 1 and the size of the deck
			newOrder = (int)((Math.random() * cardList.size() - 1) + 1);
			
			//insert card at new postion
			newCardList.add(newOrder, currentCard);
		}
		
		//set cardList field to equal new shuffled ArrayList
		cardList = newCardList;
	}
	
	/**
	 * Main method to test Deck class and associated methods.
	 * Ability to shuffle, deal one card, deal all cards, and reset the deck
	 * 
	 * @param args	takes in commands from console to test methods
	 */
	public static void main(String[] args){
 
        Scanner in = new Scanner(System.in);
        
        //create new card deck
        Deck myDeck = new Deck();
        
        System.out.println("New card deck created.\n");
        
        while(true){
        	
        	//print instructions to console
	        System.out.print("Type one of the following commands:\n"
	        		+ "-shuffle: shuffles all cards in current deck\n"
	        		+ "-deal: deals one card from top of deck\n"
	        		+ "-all: deals all cards remaining in the deck\n"
	        		+ "-reset: puts all 52 cards back in deck, ordered by number\n"
	        		+ "-end: ends game\n\n"
	        		+ "Enter command: ");
	        
	        //read user commands
	        String command = in.nextLine();   
	        
	        //shuffles all cards in deck
	        if(command.equals("shuffle")){
	        	myDeck.shuffle();
	        	System.out.println("Cards shuffled");
	        }
	        
	        //calls dealOneCard method and returns card face value/suit
	        else if (command.equals("deal")){
	        	Card myCard = myDeck.dealOneCard();
	        	if(myCard == null){
	        		System.out.println("All cards have been dealt.");
	        	}
	        	else{
	        		System.out.println("Card is: " + myCard.getNumber() + " of " + myCard.getSuit());
	        	}
	        }
	        
	        //calls dealOneCard until the deck has no more cards, prints each card to console
	        else if (command.equals("all")){
	        	int count = Deck.numOfCards;
	        	for(int i = 0; i < count; i++){
		        	Card myCard = myDeck.dealOneCard();
		        	System.out.println("Card is: " + myCard.getNumber() + " of " + myCard.getSuit());
	        	}
	        }
	        
	        //resets deck with all 52 cards in original order
	        else if (command.equals("reset")){
	        	myDeck = new Deck();
	            
	            System.out.println("Cards reset.");
	        }
	        
	        //close scanner and end game
	        else if(command.equals("end")){
	        	in.close();
	            
	            System.out.println("Game ended.");
	            break;
	        }
	        
	        //if no command is recognized, alert user
	        else{
	        	System.out.println("Invalid command.");
	        }
        }
	}
	
}
