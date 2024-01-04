import java.util.Random;
import java.util.Scanner;

public class GuessTheWordGame {
    public static void main(String[] args) {
        String[] wordList = {"java", "test", "computer", "mindera", "apple", "leaf"};
        String wordToGuess = chooseWord(wordList);
        int lives = 6;
        StringBuilder guessedWord = new StringBuilder(wordToGuess.replaceAll(".", "*"));

        System.out.println("Welcome to Guess the Word Game!");
        System.out.println("Try to guess the word. Good luck!");

        Scanner scanner = new Scanner(System.in);

        while (lives > 0) {
            System.out.println("\nWord: " + guessedWord);
            System.out.println("Lives remaining: " + lives);

            System.out.print("Enter a letter: ");
            char userGuess = scanner.next().toLowerCase().charAt(0);

            if (Character.isLetter(userGuess)) {
                if (guessedWord.indexOf(String.valueOf(userGuess)) != -1) {
                    System.out.println("You already guessed that letter. Try again.");
                } else if (wordToGuess.indexOf(userGuess) != -1) {
                    updateGuessedWord(wordToGuess, guessedWord, userGuess);
                    System.out.println("Correct guess!");
                } else {
                    System.out.println("Incorrect guess. You lose a life.");
                    lives--;
                }
            } else {
                System.out.println("Invalid input. Please enter a single letter.");
            }

            if (guessedWord.indexOf("*") == -1) {
                System.out.println("\nCongratulations! You guessed the word: " + wordToGuess);
                break;
            }
        }

        if (lives == 0) {
            System.out.println("\nSorry, you ran out of lives. The word was: " + wordToGuess);
        }

        scanner.close();
    }

    private static String chooseWord(String[] wordList) {
        Random random = new Random();
        return wordList[random.nextInt(wordList.length)];
    }

    private static void updateGuessedWord(String wordToGuess, StringBuilder guessedWord, char guessedLetter) {
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == guessedLetter) {
                guessedWord.setCharAt(i, guessedLetter);
            }
        }
    }
}
