    /**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

public class Card {
    
    private Suits suit; // Enum for suits (e.g., HEARTS, SPADES, etc.)
    private Values value; // Enum for values (e.g., ACE, KING, etc.)
    private int realValue; // Numeric representation of the card's value

    // Default constructor
    public Card() {}

    // Constructor with arguments for suit and value
    public Card(Suits suit, Values value) {
        this.suit = suit;
        this.value = value;
        this.realValue = calculateRealValue(value);
    }

    // Getter and Setter for Suit
    public Suits getSuit() {
        return suit;
    }

    public void setSuit(Suits suit) {
        this.suit = suit;
    }

    // Getter and Setter for Value
    public Values getValue() {
        return value;
    }

    public void setValue(Values value) {
        this.value = value;
        this.realValue = calculateRealValue(value); // Update realValue when value changes
    }

    // Getter for Real Value
    public int getRealValue() {
        return realValue;
    }

    // Private method to calculate the real value of the card
    private int calculateRealValue(Values value) {
    switch (value) {
        case JACK:
        case QUEEN:
        case KING:
            return 10; // Face cards are worth 10
        case ACE:
            return 11; // Default ACE value is 11
        default:
            return value.ordinal() + 1; // Numeric cards are worth their face value
    }
}


    // toString override to display the card in a readable format
    @Override
    public String toString() {
        return value + " of " + suit; // Example: "ACE of SPADES"
    }
}
