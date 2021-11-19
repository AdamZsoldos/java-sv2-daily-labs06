package day04.hangman;

import java.util.Random;
import java.util.Scanner;

public class HangmanMain {

    private final String wordToFind;
    private String wordFound;
    private int numGuesses;
    private final StringBuilder prevGuesses;

    public HangmanMain() {
        String[] words = {"apple", "pear", "orange", "yellow", "jacket", "wasps", "orangutan", "chimpanzee", "length", "width", "depth"};
        wordToFind = words[new Random().nextInt(words.length)];
        wordFound = "_".repeat(wordToFind.length());
        numGuesses = 8;
        prevGuesses = new StringBuilder();
    }

    public static void main(String[] args) {
        new HangmanMain().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);

        do {
            printStatus();
            evaluateGuess(scanner.nextLine());
        } while (numGuesses > 0 && !wordFound.equals(wordToFind));

        System.out.println();
        if (numGuesses <= 0) {
            System.out.println("You ran out of guesses! You lost!");
        } else {
            System.out.println("Congratulations! You won!");
        }
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
        System.out.println("Number of guesses: " + numGuesses);
        System.out.print("Enter next guess: ");
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