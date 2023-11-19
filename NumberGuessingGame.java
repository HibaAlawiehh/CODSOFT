
package numberguessinggame;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // scanner created
        Random random = new Random(); 
        int minRange = 1; // min range defaulted 1
        int maxRange = 100; // max range defaulted 100
        int maxAttempts = 10; // max attempts defaulted 10
        int rounds = 0; // rounds defaulted 0
        int totalAttempts = 0; // total attempts set 0
        int totalRoundsWon = 0; // total rounds set 0

        System.out.println("Welcome to the Number Guessing Game!");
        boolean playAgain = true;

        while (playAgain) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange; // target number is random 
            int attempts = 0;

            System.out.println("I have selected a number between " + minRange + " and " + maxRange +
                    ". Can you guess it?"); // guess the random

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();  // guess entered
                attempts++; 
                totalAttempts++;

                if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > targetNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    totalRoundsWon++;
                    break;
                }

                if (attempts < maxAttempts) {
                    System.out.println("Attempts left: " + (maxAttempts - attempts));
                } else {
                    System.out.println("Sorry, you have reached the maximum number of attempts. The correct number was: " + targetNumber);
                }
            }

            rounds++;
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes") || playAgainInput.equals("y");
        }

        System.out.println("Thank you for playing!");
        System.out.println("Total Rounds Played: " + rounds); // nb rounds
        System.out.println("Total Rounds Won: " + totalRoundsWon); //nb rounds win
        System.out.println("Total Attempts: " + totalAttempts); //nb attempts
    }
}