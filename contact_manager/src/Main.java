//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
// public class Main {
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("\nWelcome to your contact manager! 😊");
        System.out.println("❤".repeat(30));

        int maxContacts;
        do {
            System.out.print("\n☎How many contacts would you like to save? : ");
            maxContacts = input.nextInt();
            input.nextLine();
        } while (maxContacts <= 0);
        System.out.println("🎉Great! Got it.");

        String[][] contacts = new String[maxContacts][2];
        int contactCount = 0;

        boolean running = true;
        while (running) {
            System.out.println("\n👉Features available: ");
            System.out.println("  A. Add a contact (name & phone number)");
            System.out.println("  B. View all contacts");
            System.out.println("  C. Search a contact by name");
            System.out.println("  D. Quit");

            System.out.print("\n🧾What do you want to do? (A, B, C, or D): ");
            String inputChoose = input.nextLine().trim().toUpperCase();

            if (inputChoose.length() != 1) {
                System.out.println("❌Invalid input! Enter A, B, C, or D.");
                continue;
            }

            char featureChoose = inputChoose.charAt(0);

            switch (featureChoose) {
                case 'A':
                    if (contactCount >= maxContacts) {
                        System.out.println("😪Sorry! You've reached the maximum number of contacts.");
                        break;
                    }
                    System.out.print("Enter contact name: ");
                    String name = input.nextLine().trim();

                    System.out.print("Enter phone number: ");
                    String phone = input.nextLine().trim();

                    contacts[contactCount][0] = name;
                    contacts[contactCount][1] = phone;
                    contactCount++;

                    System.out.println("🎉Contact added!");
                    break;

                case 'B':
                    if (contactCount == 0) {
                        System.out.println("😪No contacts saved yet.");
                    } else {
                        System.out.println("\n---------- All Contacts ----------");
                        for (int i = 0; i < contactCount; i++) {
                            System.out.println((i + 1) + ". " + contacts[i][0] + " - " + contacts[i][1]);
                        }
                    }
                    break;

                case 'C':
                    System.out.print("👉Enter name to search: ");
                    String searchName = input.nextLine().trim();
                    boolean found = false;
                    for (int i = 0; i < contactCount; i++) {
                        if (contacts[i][0].equalsIgnoreCase(searchName)) {
                            System.out.println("Found: " + contacts[i][0] + " - " + contacts[i][1]);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("❌No contact found with that name.");
                    }
                    break;

                case 'D':
                    running = false;
                    System.out.println("😊Goodbye!");
                    break;

                default:
                    System.out.println("❌Invalid input! Choose A, B, C or D.");
            }
        }

        input.close();

    }
}

