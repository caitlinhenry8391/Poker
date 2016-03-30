package poker;
/**
 * Card class is a representation of a standard poker playing card. 
 * Each card has a number (face value) and a suit, both represented as Strings.
 * The cards can have four suits: hearts,spades, clubs, diamonds and with face values of Ace, 2-10, Jack, Queen, and King.
 * 
 * @author Caitlin Henry
 * @version 1.0
*/
public class Card {
	private String number;
	private String suit;
	
	/**
	 * Getter method for the card's face value.
	 * 
	 * @return the face value of the card, represented as a string to account for Face cards (Ace, King, etc)
	 */
	public String getNumber(){
		return number;
	}
	
	/**
	 * Getter method for the card's suit.
	 * 
	 * @return 		the face value of the card, represented as a string (Club, Spade, Diamond, or Heart)
	 */
	public String getSuit(){
		return suit;
	}
	
	/**
	 * Constructor for a card
	 * Face values and suits are sent to constructor as a integers, and converted to appropriate String values
	 * 
	 * @param newNumber		the integer representation of the face value of the card (2-14)
	 * @param newSuit		the integer representation of the face value of the card (Club, Spade, Diamond, or Heart)
	 */
	public Card(int newNumber, int newSuit){
		switch(newNumber){
			case 11: number =  "Jack"; break;
			case 12: number = "Queen"; break;
			case 13: number = "King"; break;
			case 14: number = "Ace"; break;
			default: number = Integer.toString(newNumber); break;
		}
		
		switch(newSuit){
			case 1: suit = "Spades"; break;
			case 2: suit = "Clubs"; break;
			case 3: suit = "Diamonds"; break;
			case 4: suit = "Hearts"; break;
		}

	}
	
}
