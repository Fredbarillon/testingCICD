package org.app;

import java.util.HashSet;
import java.util.Set;

public class Hangman {
    private final WordGenerator generator;
    private String wordToGuess;
    private final Set<Character> guessedLetters = new HashSet<>();
    private int attemptsLeft;


    public Hangman(WordGenerator generator, int maxAttempts) {
        if (generator == null) throw new IllegalArgumentException("no words provided");
        if (maxAttempts <= 0) throw new IllegalArgumentException("maxAttempts must be > 0");
        this.generator = generator;
        this.attemptsLeft = maxAttempts;
    }

    public boolean guess(char letter) {
        if (isGameOver()) return false;
        char c = Character.toLowerCase(letter);
        boolean found = guessedLetters.contains(c);
        guessedLetters.add(c);

        if (!found) {
            attemptsLeft--;
        }
        return found;
    }

    public String getMaskedWord() {
        return wordToGuess;
    }

    public boolean isGameWon() {
        for (int i = 0; i < wordToGuess.length(); i++) {
            char c = wordToGuess.charAt(i);
            if (Character.isLetter(c) && !guessedLetters.contains(c)) {
                return false;
            }
        }
        return true;
    }

    public boolean isGameOver() {
        return isGameWon() || attemptsLeft <= 0;
    }

    public int getAttemptsLeft() {
        return attemptsLeft;
    }
}
