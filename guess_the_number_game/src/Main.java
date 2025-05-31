//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String playAgain;

        System.out.println("\n🎮 Welcome to the \"Guess the Number\" Game 😊!");

        do {
            int correctNum = (int) (1 + (Math.random() * 100));
            int userChoose;
            int numberOfTests = 5;
            boolean guessedCorrectly = false;

            System.out.println();
            System.out.println("*".repeat(60));
            System.out.println("👉 Here is the principle:" +
                    "\nI'm thinking of a number between 1 and 100.\n" +
                    "Your mission is to guess it — but be careful, you only have 5 chances!\n" +
                    "After each guess, I’ll tell you if the secret number is higher or lower than your guess.\n" +
                    "😏 Can you find the right number before you run out of attempts?\n" +
                    "\nGet ready and think wisely — your 5 trials start now!");
            System.out.println("*".repeat(60));

            while (numberOfTests > 0) {
                try {
                    System.out.print("\n🎯 Please choose a number between 1 and 100: ");
                    userChoose = Integer.parseInt(input.nextLine());

                    if (userChoose < 1 || userChoose > 100) {
                        System.out.println("❌ Invalid input. Choose a number between 1 and 100.");
                        continue;
                    }

                    if (userChoose < correctNum) {
                        System.out.println("🙃 Nope! The number is *greater*.");
                    } else if (userChoose > correctNum) {
                        System.out.println("🙃 Nope! The number is *lower*.");
                    } else {
                        System.out.println("\n🎉 Great! You found the number in " + (6 - numberOfTests) + " trial" + ((6 - numberOfTests == 1) ? "" : "s") + "!");
                        guessedCorrectly = true;
                        break;
                    }

                    numberOfTests--;
                    if (numberOfTests > 0) {
                        System.out.println("🕔 You have " + numberOfTests + " trial" + (numberOfTests == 1 ? "" : "s") + " left.");
                    }

                } catch (Exception e) {
                    System.out.println("❌ Invalid input. Please enter a valid number.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("\n💔 Game over! You've used all your trials.");
                System.out.println("👉 The correct number was " + correctNum + ".");
            }

            // Demander si l'utilisateur veut rejouer
            do {
                System.out.print("\n🔁 Would you like to play again? (yes/no): ");
                playAgain = input.nextLine().trim().toLowerCase();
            } while (!playAgain.equals("yes") && !playAgain.equals("no"));

        } while (playAgain.equals("yes"));

        System.out.println("\n😊 Thanks for playing the Guess the Number Game! See you next time.");
        input.close();

    }
}