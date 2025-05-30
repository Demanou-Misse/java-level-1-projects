//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // The five Questions

        String[] questions = {
                " Which command shows the modified files in your project?",
                " Which command uploads your local commits to GitHub?",
                " What command initializes a new Git repository?",
                " What command creates a new branch?",
                " Which command is used to merge branches?"
        };

        // The 3 options for each Questions

        String[][] options = {
                {"   A. git commit", "   B. git status", "   C. git push"},
                {"   A. git push", "   B. git pull", "   C. git status"},
                {"   A. git init", "   B. git clone", "   C. git remote"},
                {"   A. git merge", "   B. git checkout", "   C. git branch"},
                {"   A. git add", "   B. git merge", "    C. git switch"}
        };

        // The correct answers (correspond to A, B, or C)

        char[] answers = {'B', 'A', 'A', 'C', 'B'};

        int score = 0;

        System.out.println("\n🎯 Welcome to the Git Multiple-Choice Quiz!");
        System.out.println("You have 5 questions. Choose A, B, or C.");
        System.out.println("--------------------------------------------------");


        for (int i = 0; i < questions.length; i++){
            System.out.println("\nQuestion " + (i +1) + ":" + questions[i]);
            for (String option : options[i]){
                System.out.println(option);
            }

            boolean validInput = false;
            char answer = ' ';
            while (!validInput) {
                System.out.print("👉 Your answer (A/B/C): ");
                String inputLine = input.nextLine().trim().toUpperCase();

                if (inputLine.length() != 1) {
                    System.out.println("❗ Invalid input. Please enter A, B or C.");
                    continue;
                }

                answer = inputLine.charAt(0);
                if (answer == 'A' || answer == 'B' || answer == 'C') {
                    validInput = true;
                } else {
                    System.out.println("❗ Invalid choice. Try again and please make sure to enter A, B, or C.");
                }
            }


            if (answer != answers[i]){
                System.out.println("❌ Wrong. The correct answer was: " + answers[i]);
            } else {
                System.out.println("✅ Correct!");
                score++;
            }
        }

        // final result
        System.out.println("\n🎉 Quiz finished!");
        System.out.println("Your final score: " + score + "/" + questions.length);

        if (score == questions.length) {
            System.out.println("🌟 Excellent work!");
        } else if (score >= 3) {
            System.out.println("👍 Good job! Keep learning.");
        } else {
            System.out.println("📘 Don't worry. Keep practicing Git.");
        }

        input.close();

    }

}

