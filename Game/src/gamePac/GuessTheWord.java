package gamePac;

import java.util.Scanner;

public class GuessTheWord {

	// Variable to control if the game is still being played
	private boolean play = true;
	
	// Object to handle the word being guessed
	private Words randomWord = new Words();
	
	// Object to read user input
	private Scanner scanner = new Scanner(System.in);
	
	// Number of rounds left
	private int rounds = 10;
	
	// The last letter guessed by the user
	private char lastRound;

	// Method to start the game
	public void start() {

		// Loop until the game is over
		do {
			showWord(); // Show the current state of the word being guessed
			getInput(); // Read the user's guess
			checkInput(); // Check if the guess is correct and update the game state
		} while (play);
	}

	// Method to show the current state of the word being guessed
	void showWord() {
		System.out.println("You have " + rounds + " tries left.");
		System.out.println(randomWord);
	}

	// Method to read the user's guess
	void getInput() {

		System.out.print("Enter a letter to guess the word: ");
		String userGuess = scanner.nextLine();
		lastRound = userGuess.charAt(0);

	}

	// Method to check if the guess is correct and update the game state
	void checkInput() {

		boolean isGuessedRight = randomWord.guess(lastRound);

		if (isGuessedRight) {
			if (randomWord.isGuessedRight()) {
				System.out.println("Congrats, you won!");
				System.out.println("The word is: " + randomWord);
				play = false; // Game over
			}
		} else {
			rounds--;

			if (rounds == 0) {
				System.out.println("Game Over!");
				play = false; // Game over
			}
		}
	}

	// Method to end the game
	public void end() {
		scanner.close();
	}

}
