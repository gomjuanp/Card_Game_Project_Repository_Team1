/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * BlackJack Game Class
 */
public class BlackJack extends Game {

    ArrayList<Player> players = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    CardDeck cardDeck = new CardDeck(); // Instance for deck operations
    HandValidation handValidation = new HandValidation(); // Hand validation logic

    public BlackJack() {
        super("Black Jack"); // Pass the game name to the Game class constructor
    }

    @Override
    public void play() {
        System.out.println("Welcome to Casino Java! We hope you like Black Jack!");

        // Get player's name and create player
        System.out.println("Enter your name:");
        String userName = scanner.nextLine().trim();
        Player player = new Player(userName);
        players.add(player);

        // Create Dealer
        Player dealer = new Player("Dealer");

        boolean gameInProgress = true;

        while (gameInProgress) {
            // Deal initial cards
            dealFirstCards(player, dealer);

            // Show the player's hand and the dealer's initial hand
            displayPlayerHand(player);
            displayDealerInitialHand(dealer);

            // Player's Turn
            playerTurn(player);

            // Dealer's Turn
            dealerTurn(dealer);

            // Reveal dealer's full hand
            displayDealerHand(dealer);

            // Declare the winner
            declareWinner(player, dealer);

            // Ask if the user wants to play again
            System.out.println("Do you want to play again? (yes/no)");
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("yes")) {
                gameInProgress = false;
                System.out.println("Thank you for playing Black Jack! Goodbye!");
            } else {
                resetGame(player, dealer);
            }
        }
    }

    private void dealFirstCards(Player player, Player dealer) {
        player.addCardToHand(cardDeck.deal(1).get(0)); // First card for player
        player.addCardToHand(cardDeck.deal(1).get(0)); // Second card for player
        dealer.addCardToHand(cardDeck.deal(1).get(0)); // First card for dealer
        dealer.addCardToHand(cardDeck.deal(1).get(0)); // Second card for dealer
    }

    private void displayPlayerHand(Player player) {
        int total = handValidation.playerHandValidation(player.getHand());
        System.out.println(player.getName() + "'s hand: " + player.getHand() + " (Total: " + cardDeck.calculateScore(player.getHand()) + ")");

    }

    private void displayDealerInitialHand(Player dealer) {
        System.out.println("Dealer's visible card: " + dealer.getHand().get(0));
    }

    private void displayDealerHand(Player dealer) {
        int total = handValidation.playerHandValidation(dealer.getHand());
        System.out.println("Dealer's full hand: " + dealer.getHand() + " (Total: " + cardDeck.calculateScore(dealer.getHand()) + ")");

    }

    private void playerTurn(Player player) {
        while (handValidation.playerHandValidation(player.getHand()) < 21) {
            System.out.println(player.getName() + ", type 'Hit' or 'Stand':");
            String playerMove = scanner.nextLine().trim().toUpperCase();

            if (playerMove.equals("HIT")) {
                player.addCardToHand(cardDeck.deal(1).get(0)); // Player hits
                displayPlayerHand(player);
            } else if (playerMove.equals("STAND")) {
                break; // Player stands
            } else {
                System.out.println("Invalid input. Please type 'Hit' or 'Stand'.");
            }
        }
    }

    private void dealerTurn(Player dealer) {
        while (handValidation.playerHandValidation(dealer.getHand()) <= 16) {
            dealer.addCardToHand(cardDeck.deal(1).get(0)); // Dealer hits
            System.out.println("Dealer hits.");
        }
    }

    @Override
    public void declareWinner(Player player, Player dealer) {
        int playerScore = handValidation.playerHandValidation(player.getHand());
        int dealerScore = handValidation.playerHandValidation(dealer.getHand());

        System.out.println(player.getName() + "'s score: " + playerScore);
        System.out.println("Dealer's score: " + dealerScore);

        if (playerScore > 21) {
            System.out.println("Dealer wins! " + player.getName() + " busted.");
        } else if (dealerScore > 21) {
            System.out.println(player.getName() + " wins! Dealer busted.");
        } else if (playerScore > dealerScore) {
            System.out.println(player.getName() + " wins!");
        } else if (dealerScore > playerScore) {
            System.out.println("Dealer wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }

    private void resetGame(Player player, Player dealer) {
        player.clearHand();
        dealer.clearHand();
        cardDeck.resetDeck();
    }

    public static void main(String[] args) {
        BlackJack game = new BlackJack();
        game.play();
    }
}



