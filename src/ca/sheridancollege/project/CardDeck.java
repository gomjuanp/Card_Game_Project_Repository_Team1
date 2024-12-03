/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
    
public class CardDeck {
    private List<Card> cards; // List to hold the deck of cards

    // Constructor to initialize and shuffle the deck
    public CardDeck() {
        cards = new ArrayList<>();
        initializeDeck();
        shuffleDeck();
    }

    // Initializes the deck with all possible cards
    private void initializeDeck() {
        for (Suits suit : Suits.values()) { // Using the correct Suits enum
            for (Values value : Values.values()) { // Using the correct Values enum
                cards.add(new Card(suit, value)); // Create a new Card object
            }
        }
    }

    // Shuffles the deck
    public void shuffleDeck() {
        Collections.shuffle(cards);
    }

    // Deals a specified number of cards
    public List<Card> deal(int numberOfCards) {
        if (numberOfCards < 0 || numberOfCards > cards.size()) {
            throw new IllegalArgumentException("Invalid number of cards to deal.");
        }
        List<Card> dealtCards = new ArrayList<>();
        for (int i = 0; i < numberOfCards; i++) {
            dealtCards.add(cards.remove(0)); // Removes the top card
        }
        return dealtCards;
    }

    // Calculates the total score of a given hand
public int calculateScore(List<Card> hand) {
    int score = 0;
    int aceCount = 0;

    for (Card card : hand) {
        int value = card.getRealValue();

        if (value == 11) { // Ace
            aceCount++;
            score += 11; // Default value for Ace
        } else {
            score += value; // Add value of other cards
        }
    }

    // Adjust Aces from 11 to 1 if the total score exceeds 21
    while (score > 21 && aceCount > 0) {
        score -= 10; // Reduce score by 10 for each Ace adjusted
        aceCount--;
    }

    return score;
}



    // Determines the winner between two hands
    public String declareWinner(List<Card> playerHand, List<Card> dealerHand) {
        int playerScore = calculateScore(playerHand);
        int dealerScore = calculateScore(dealerHand);

        System.out.println("Player Score: " + playerScore);
        System.out.println("Dealer Score: " + dealerScore);

        if (playerScore > 21) {
            return "Dealer wins! Player busted.";
        } else if (dealerScore > 21) {
            return "Player wins! Dealer busted.";
        } else if (playerScore > dealerScore) {
            return "Player wins!";
        } else if (dealerScore > playerScore) {
            return "Dealer wins!";
        } else {
            return "It's a draw!";
        }
    }

    // Resets the deck to its initial state
    public void resetDeck() {
        cards.clear();
        initializeDeck();
        shuffleDeck();
    }
}


