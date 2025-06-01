import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double amountUser;
        char conversionChoose = ' ';
        String decision = "yes";

        System.out.println("\n😊Welcome to your \"Currency Converter\"!");
        System.out.println("💲 ".repeat(20));
        System.out.println("\n📌 Current fixed conversion rates used in this program:");
        System.out.println("   ➤ 1 USD   = 0.92 EUR");
        System.out.println("   ➤ 1 EUR   = 1.09 USD");
        System.out.println("   ➤ 1 USD   = 610 FCFA");
        System.out.println("   ➤ 1 FCFA  = 0.00164 USD");
        System.out.println("   ➤ 1 EUR   = 655.96 FCFA");
        System.out.println("   ➤ 1 FCFA  = 0.0015 EUR");

        do {

            try {
                System.out.print("\n👉How much money would you like to convert? Please enter only the amount: ");
                String userInput = input.nextLine().replace(",", ".");
                amountUser = Double.parseDouble(userInput);

                if (amountUser <= 0){
                    System.out.println("❌Invalid input. Please enter an amount greater than '0'.");
                    continue;
                }

                System.out.println("\nFeatures available: " +
                        "\n" +
                        "   A. USD → EUR \n" +
                        "   B. EUR → USD \n" +
                        "   C. FCFA → USD \n" +
                        "   D. USD → FCFA \n" +
                        "   E. FCFA → EUR \n" +
                        "   F. EUR → FCFA ");

                boolean validInput = false;
                while (!validInput) {
                    System.out.print("\n👉Which conversion would you like to make? (A, B, C, D, E, or F): ");
                    String inputUser = input.nextLine().trim().toUpperCase();

                    if (inputUser.length() != 1) {
                        System.out.println("❌Invalid input. Please make sure to enter a single character (A-F).");
                        continue;
                    }

                    conversionChoose = inputUser.charAt(0);

                    if ("ABCDEF".indexOf(conversionChoose) == -1) {
                        validInput = true;
                    } else {
                        System.out.println("❌Invalid input. Please make sure to enter A, B, C, D, E, or F");
                    }

                }

                switch (conversionChoose) {

                    case 'A':
                        System.out.println(" ".repeat(5) + amountUser + " USD " + "  ➤   " + ( Math.round(amountUser * 0.92) )  + " EUR");
                        break;
                    case 'B':
                        System.out.println(" ".repeat(5) + amountUser + " EUR " + "  ➤   " + ( Math.round(amountUser * 1.09) ) + " USD");
                        break;
                    case 'C':
                        System.out.println(" ".repeat(5) + amountUser + " FCFA " + "  ➤   " + ( Math.round(amountUser * 0.00164) ) + " USD");
                        break;
                    case 'D':
                        System.out.println(" ".repeat(5) + amountUser + " USD " + "  ➤   " + ( Math.round(amountUser * 610) ) + " FCFA");
                        break;
                    case 'E':
                        System.out.println(" ".repeat(5) + amountUser + " FCFA " + "  ➤   " + ( Math.round(amountUser * 0.0015) ) + " EUR");
                        break;
                    case 'F':
                        System.out.println(" ".repeat(5) + amountUser + " EUR " + "  ➤   " + ( Math.round(amountUser * 655.96) ) + " FCFA");
                        break;
                }

            } catch (Exception e) {
                System.out.println("❌Invalid input. Please make sure to enter a valid number.");
                continue;
            }

            do {
                System.out.print("\n💫Would you like to convert another amount again? (yes/no): ");
                decision = input.nextLine().trim().toLowerCase();

                if (!decision.equals("yes") && !decision.equals("no")){
                    System.out.println("❌Invalid input. Please make sure to enter 'yes' or 'no'.");
                }

            } while (!decision.equals("yes") && !decision.equals("no"));

        } while (decision.equalsIgnoreCase("yes"));

        System.out.println("\n🎉Thanks for testing our 'Currency Converter' project. See you next time!");

        input.close();
    }
}