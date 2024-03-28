import Hangman.Hangman;
import Hangman.HangmanFactory;

public class Main {
    public static void main(String[] args) {
        String difficulty = args.length > 0 ? args[0] : "medium";
        Hangman game = HangmanFactory.createHangman(difficulty);

        while (!game.isGameOver()) {
            System.out.println("Score: " + game.getScore());
            System.out.println("Word: " + game.getDisplayedWord());
            System.out.println("Wrong letters: " + game.getWrongLetters());
            System.out.print("Guess a letter: ");
            char guess = new java.util.Scanner(System.in).next().charAt(0);
            if (game.guessLetter(guess)) {
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect guess.");
                game.wrongGuesses++;
                int triesLeft = game.difficulty.getMaxTries() - game.wrongGuesses;
                System.out.println("Tries left: " + triesLeft);
            }
        }
        System.out.println(game.getVictoryMessage());
    }
}
