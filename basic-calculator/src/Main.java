//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String decision;

        System.out.println("Welcome to your personal calculator! 😊");
        System.out.println("*********************************");

        do {

            System.out.println(" ");
            System.out.print("👉 Please enter the first number: ");
            double a = input.nextDouble();
            input.nextLine();

            System.out.println(" ");
            System.out.print("👉 Please enter the second number: ");
            double b = input.nextDouble();
            input.nextLine();

            System.out.println("Available operations:");
            System.out.println("    1. Addition");
            System.out.println("    2. Subtraction");
            System.out.println("    3. Multiplication");
            System.out.println("    4. Division");
            System.out.println(" ");

            // Choose the operation

            int corresponding_number;
            do {
                System.out.print("👉 Please select an operation by entering its number (1–4): ");
                corresponding_number = input.nextInt();
                input.nextLine();
            } while (corresponding_number < 1 || corresponding_number > 4);

            //  Steps of the operation

            System.out.println(" ");
            switch (corresponding_number){
                case 1:
                    System.out.println("The result of (" + a + " + " + b + ") is: " + (a + b));
                    break;
                case 2:
                    System.out.println("The result of (" + a + " - " + b + ") is: " + (a - b));
                    break;
                case 3:
                    System.out.println("The result of (" + a + " * " + b + ") is: " + (a * b));
                    break;
                case 4:
                    if (b != 0){
                        System.out.printf("The result of (%.2f + %.2f) is: %.2f\n", a, b, a + b);
                    } else
                        System.out.println("⚠️ Division by zero is not allowed.");
                    break;
            }

            System.out.println(" ");
            System.out.println("**************************************************");
            System.out.println(" ");

            // replay code

            System.out.print("🔁 Would you like to perform another calculation? (yes/no): ");
            decision = input.nextLine();

        } while (decision.equalsIgnoreCase("yes"));

        System.out.println("🎉 Thank you for using my first Java calculator. See you next time!");
        
    }
}