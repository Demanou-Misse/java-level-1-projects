//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {

    public static double[] readNumbers(Scanner input, int count) {
        double[] numbers = new double[count];
        for (int i = 0; i < count; i++) {
            while (true) {
                try {
                    System.out.printf("   🎯Please enter the number %d : ", i + 1);
                    String entry = input.nextLine().trim().replace(",", ".");
                    numbers[i] = Double.parseDouble(entry);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("❌Invalid input.");
                }
            }
        }
        return numbers;
    }

    public static double calculateSum(double[] numbers) {
        double sum = 0;
        for (double n : numbers) {
            sum += n;
        }
        return sum;
    }

    public static double calculateAverage(double[] numbers) {
        return calculateSum(numbers) / numbers.length;
    }

    public static double findMin(double[] numbers) {
        double min = numbers[0];
        for (double n : numbers) {
            if (n < min) min = n;
        }
        return min;
    }

    public static double findMax(double[] numbers) {
        double max = numbers[0];
        for (double n : numbers) {
            if (n > max) max = n;
        }
        return max;
    }

    public static int readChoice(Scanner input) {
        while (true) {
            System.out.println("\n🧾What would you like to do ?");
            System.out.println("    1. Sum");
            System.out.println("    2. Average");
            System.out.println("    3. Minimum");
            System.out.println("    4. Maximum");
            System.out.print("👉Your choice : ");
            String choiceStr = input.nextLine().trim();
            try {
                int choice = Integer.parseInt(choiceStr);
                if (choice >= 1 && choice <= 4) {
                    return choice;
                } else {
                    System.out.println("❌Invalid input. Please make sure to enter a number between 1 and 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌Invalid input. Please make sure to enter a number between 1 and 4.");
            }
        }
    }

    public static boolean playAgain(Scanner input) {
        while (true) {
            System.out.print("\n💫Would you like to try again ? (yes/no) : ");
            String response = input.nextLine().trim().toLowerCase();
            if (response.equals("yes")) return true;
            if (response.equals("no")) return false;
            System.out.println("❌Invalid input. Please enter 'yes' ou 'no'.");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n★ 😊Welcome to your 'Multi Number Operations' ★");
        System.out.println("=".repeat(40));

        do {
            int count;
            while (true) {
                System.out.print("\n👉How many numbers would you like to enter ? ");
                try {
                    String userInput = input.nextLine().trim();
                    count = Integer.parseInt(userInput);
                    if (count > 0) break;
                    System.out.println("Please enter a number greater than '0'.");
                } catch (NumberFormatException e) {
                    System.out.println("❌Invalid input.");
                }
            }

            double[] numbers = readNumbers(input, count);
            int choice = readChoice(input);

            switch (choice) {
                case 1:
                    System.out.printf("\nResult : Sum = %.2f\n", calculateSum(numbers));
                    break;
                case 2:
                    System.out.printf("\nResult : Average = %.2f\n", calculateAverage(numbers));
                    break;
                case 3:
                    System.out.printf("\nResult : Minimum = %.2f\n", findMin(numbers));
                    break;
                case 4:
                    System.out.printf("\nResult : Maximum = %.2f\n", findMax(numbers));
                    break;
            }

        } while (playAgain(input));

        System.out.println("\n🎉Thanks for using the calculator !");
        input.close();
    }

}