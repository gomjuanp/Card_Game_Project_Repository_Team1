/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author Juan
 */
public class Player {

    private String name; // Player's name
    private ArrayList<Card> hand; // Player's hand of cards

    // Constructor
    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    /**
     * @return the player's name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set for the player
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the player's hand
     */
    public ArrayList<Card> getHand() {
        return hand;
    }

    // Method to add a card to the player's hand
    public void addCardToHand(Card card) {
        if (card != null) {
            hand.add(card);
        } else {
            System.out.println("Cannot add a null card to the hand.");
        }
    }

    // Method to display the player's hand
    public void showHand() {
        System.out.println(name + "'s hand:");
        for (Card card : hand) {
            System.out.println(card);
        }
    }

    // Method to clear the player's hand
    public void clearHand() {
        if (hand != null) {
            hand.clear();
        } else {
            System.out.println("The hand is already empty.");
        }
    }
}

