package day04.hangman;

import java.util.Random;
import java.util.Scanner;

public class HangmanMain {

    private final String wordToFind;
    private String wordFound;
    private int numGuesses;
    private final StringBuilder prevGuesses;

    public HangmanMain(String wordToFind, int numGuesses) {
        this.wordToFind = wordToFind;
        wordFound = "_".repeat(wordToFind.length());
        this.numGuesses = numGuesses;
        prevGuesses = new StringBuilder();
    }

    public static void main(String[] args) {
        new HangmanMain(Words.getRandomWord(new Random()), 8).run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);

        do {
            printStatus();
            evaluateGuess(scanner.nextLine().toLowerCase());
        } while (numGuesses > 0 && !wordFound.equals(wordToFind));

        printResult(numGuesses > 0);
    }

    private void evaluateGuess(String guess) {
        if (!guessValid(guess)) {
            System.out.println("Invalid guess!");
        } else if (guessRepeated(guess)) {
            System.out.println("Letter already guessed!");
        } else if (!guessCorrect(guess)) {
            System.out.println("Incorrect guess!");
            numGuesses--;
            prevGuesses.append(guess);
        } else {
            System.out.println("Correct guess!");
            wordFound = updateWordFound(guess);
            prevGuesses.append(guess);
        }
    }

    private void printStatus() {
        System.out.println();
        System.out.println("Word to find: " + wordFound);
        System.out.println("Guesses left: " + numGuesses);
        System.out.print("Enter next guess: ");
    }

    private void printResult(boolean won) {
        System.out.println();
        if (won) {
            System.out.println("Congratulations! You won!");
        } else {
            System.out.println("You ran out of guesses! You lost!");
        }
    }

    private boolean guessValid(String guess) {
        if (guess.length() != 1) return false;
        return Character.isAlphabetic(guess.charAt(0));
    }

    private boolean guessRepeated(String guess) {
        return prevGuesses.toString().contains(guess);
    }

    private boolean guessCorrect(String guess) {
        if (wordFound.contains(guess)) return false;
        return wordToFind.contains(guess);
    }

    private String updateWordFound(String guess) {
        char[] chars = wordFound.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (wordToFind.charAt(i) == guess.charAt(0)) {
                chars[i] = guess.charAt(0);
            }
        }
        return new String(chars);
    }
}
