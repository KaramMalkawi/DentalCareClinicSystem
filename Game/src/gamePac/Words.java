package gamePac;

import java.util.Random;

//A class that contains an array of words, selects a random word from that array and allows guessing of that word.
public class Words {

	private String[] randomWords = { "animals", "happiness", "indefinite", "steady", "birthday", "extreme", "rights",
	"properties", "ceremony", "independence", "beneath", "information", "students", "employee" };	// Array of words to choose from
	
	private String selectedWord;	// The word that has been selected
	
	private char[] letters;		// The letters of the word that have been guessed correctly
	
	private Random random = new Random();	// A random number generator
	
	//Constructs a new Words object by selecting a random word from the array of words and initializing the letters array.
	public Words() {
		selectedWord = randomWords[random.nextInt(randomWords.length)];
		letters = new char[selectedWord.length()];
	}
	
	/*
	 * Returns a string representation of the letters array with hyphens for letters that have not been guessed yet.
	 * 
	 * @return A string representation of the letters array.
	 * */
	public String toString() {
	
		StringBuilder text = new StringBuilder();
		
		for (char letter : letters) {
			 text.append(letter == '\u0000' ? '-' : letter);
			 text.append(' ');
		}
		return text.toString();
	}
	
	/*
	* Checks if all the letters of the selected word have been guessed.
	*
	* @return True if all the letters have been guessed, false otherwise.
	* */
	public boolean isGuessedRight() {
		
		for (char letter : letters) {
			
		if (letter == '\u0000') 
			return false;
		
		}
		return true;
	}
	
	/*
	* Guesses a letter and updates the letters array accordingly.
	*
	* @param letter The letter to guess.
	* 
	* @return True if the letter was guessed correctly, false otherwise.
	* */
	public boolean guess(char letter) {
	
		boolean guessedRight = false;
		
		for (int i = 0; i < selectedWord.length(); i++) {
			
			if (letter == selectedWord.charAt(i)) {
				letters[i] = letter;
				guessedRight = true;
			}
			
		}
		return guessedRight;
	
	}
}



