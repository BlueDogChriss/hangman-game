package Hangman;

import Hangman.DifficultyManagement.Difficulty;
import Hangman.DifficultyManagement.EasyMode;
import Hangman.DifficultyManagement.HardMode;
import Hangman.DifficultyManagement.MediumMode;
import Hangman.WordPicker.WordPicker;
import Hangman.WordPicker.RandomWordPick;

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

