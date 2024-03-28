package Hangman.WordPicker;

import java.util.Random;

public class RandomWordPick implements WordPicker {
    private String[] words;

    public RandomWordPick(String[] words){
        this.words = words;
    }

    @Override
    public String pickWord() {

        Random random = new Random();

        return words[random.nextInt(words.length)];

    }
}
