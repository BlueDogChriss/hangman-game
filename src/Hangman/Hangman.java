package Hangman;

import DifficultyManagement.Difficulty;
import WordPicker.WordPicker;

import java.util.ArrayList;

public class Hangman {

    private String hiddenWord;
    private ArrayList<Character> guessedLetters;
    public Difficulty difficulty;
    private WordPicker wordPicker;
    public int wrongGuesses;
    private int score;

    public Hangman() {

    }
    public Hangman(Difficulty difficulty, WordPicker wordPicker) {
        this.hiddenWord = wordPicker.pickWord();
        this.guessedLetters = new ArrayList<>();
        this.difficulty = difficulty;
        this.wordPicker = wordPicker;
        this.wrongGuesses = 0;
        this.score = 0;
    }

    public String getDisplayedWord() {
        StringBuilder display = new StringBuilder();
        for (char c : hiddenWord.toCharArray()) {
            if (guessedLetters.contains(c)) {
                display.append(c);
            } else {
                display.append("-");
            }
        }
        return display.toString();
    }

    public boolean guessLetter(char letter) {
        letter = Character.toLowerCase(letter);
        if (guessedLetters.contains(letter)) {
            return false;
        }
        guessedLetters.add(letter);
        return hiddenWord.toLowerCase().indexOf(letter) != -1;
    }

    public boolean isGameOver() {
        return wrongGuesses >= difficulty.getMaxTries() || getDisplayedWord().equals(hiddenWord);
    }

    public void updateScore() {
        if (isGameOver() && getDisplayedWord().equals(hiddenWord)) {
            score = score+10;
        }
    }

    public int getScore() {
        return score;
    }

    public String getVictoryMessage() {
        if (isGameOver() && getDisplayedWord().equals(hiddenWord)) {
            return "You guessed right! You win!";
        } else if (isGameOver()) {
            return "You ran out of guesses! The word was: " + hiddenWord;
        }
        return null;
    }

    public String getWrongLetters() {
        StringBuilder wrong = new StringBuilder();
        for (char c : guessedLetters) {
            if (!hiddenWord.toLowerCase().contains(String.valueOf(c))) {
                wrong.append(c + " ");
            }
        }
        return wrong.toString().trim();
    }
}


