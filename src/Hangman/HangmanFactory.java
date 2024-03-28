package Hangman;

import DifficultyManagement.Difficulty;
import DifficultyManagement.EasyMode;
import DifficultyManagement.HardMode;
import DifficultyManagement.MediumMode;
import WordPicker.WordPicker;
import WordPicker.RandomWordPick;

public class HangmanFactory {

    public static Hangman createHangman(String difficulty) {
        Difficulty diff;
        String[] wordList = {"apple", "banana", "orange", "computer"};
        WordPicker picker = new RandomWordPick(wordList);
        switch (difficulty.toLowerCase()) {
            case "easy":
                diff = new EasyMode();
                break;
            case "medium":
                diff = new MediumMode();
                break;
            case "hard":
                diff = new HardMode();
                break;
            default:
                diff = new MediumMode();
        }
        return new Hangman(diff, picker);
    }
}

