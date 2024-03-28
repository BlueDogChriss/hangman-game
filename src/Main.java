import Hangman.Hangman;
import Hangman.HangmanFactory;

public class Main {
    public static void main(String[] args) {
        String difficulty = "Easy"; //manual difficulty sett
        int totalScore = 0;
        char playAgain;
        do {
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
                    System.out.println("Incorrect! Try Again...");
                    game.wrongGuesses++;
                    int triesLeft = game.difficulty.getMaxTries() - game.wrongGuesses;
                    System.out.println("Tries left: " + triesLeft);
                }
            }
            game.updateScore();
            System.out.println(game.getVictoryMessage());

            System.out.println("Play again? (y/n)");
            playAgain = new java.util.Scanner(System.in).next().charAt(0);

            totalScore = game.getScore();
        } while (playAgain == 'y' || playAgain == 'Y');


        System.out.println("Thanks for playing! Final score: " + totalScore);
    }
}

