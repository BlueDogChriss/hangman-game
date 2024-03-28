package Hangman.DifficultyManagement;

public class MediumMode implements Difficulty{
    @Override
    public int getMaxTries() {
        return 8;
    }
}
