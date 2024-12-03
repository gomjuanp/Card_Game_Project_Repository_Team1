/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * This class will validate the Hand of the player
 *
 * @author Juan Pablo Ordonez Gomez 991745862
 */
public class HandValidation {

    public HandValidation() {
    }

   public int playerHandValidation(ArrayList<Card> hand) {
    int total = 0;
    int aceCount = 0;

    for (Card card : hand) {
        int value = card.getRealValue();
        if (value == 11) { // If card is Ace
            aceCount++;
        }
        total += value;
    }

    // Adjust the total value if there are Aces and the total exceeds 21
    while (total > 21 && aceCount > 0) {
        total -= 10; // Convert one Ace from 11 to 1
        aceCount--;
    }

    return total;
    }
}

