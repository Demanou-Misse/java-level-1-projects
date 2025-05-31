//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String characters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()-_=+[]{};:,.<>?/";
        int maxWord;
        String password;
        String decision;

        System.out.println("\n😊Welcome to your password generator!");
        System.out.println("*".repeat(40));

        do {

            boolean validInput = false;
            while (!validInput) {

                try {
                    System.out.print("\nHow long should be your password? Please enter a valid number: ");
                    maxWord = Integer.parseInt(input.nextLine());

                    if (maxWord <=0) {
                        System.out.println("❌Invalid input. Please enter a number greater than 0.");
                        continue;
                    }

                    System.out.println("🎉Great! Got it.");
                    char[] tableWords = new char[maxWord];

                    for (int i = 0; i < maxWord; i++) {
                        tableWords[i] = characters.charAt( (int)(Math.random() * characters.length()) );
                    }

                    password = new String(tableWords);
                    System.out.println("\n🎀Your password is: " + password);

                    validInput = true;

                } catch (Exception e) {
                    System.out.println("❌Invalid input. Please make sure to enter a valid number.");
                }
            }

            // Try another password

            do {
                System.out.print("\n🎯Would you like to try another password? (yes/no): ");
                decision = input.nextLine().trim().toLowerCase();

                if (!decision.equals("yes") && !decision.equals("no")) {
                    System.out.println("❗Please enter 'yes' or 'no'.");
                }
                
            } while (!decision.equals("yes") && !decision.equals("no"));


        } while (decision.equalsIgnoreCase("yes"));

        System.out.println(" ");
        System.out.println("🎉Thanks for testing our password generator! See you next time!");

        input.close();

    }
}