package TutorialWill;

import java.util.Scanner;

public class Console {
    private static Scanner input = new Scanner(System.in);

    public static double readNumber(String prompt, int min, int max) {
        double number;

        System.out.print(prompt);
        while (true) {
            try {
                number = input.nextDouble();
                if (number >= min && number <= max) {
                    break;
                }
            } catch (RuntimeException e) {
                System.out.println("invalid input");
                input.nextLine();
            }
            System.out.print("Enter a number between " + min + " and " + max + ": ");
        }
        return number;
    }

    public static double readNumber(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                return input.nextDouble();
            } catch (RuntimeException e) {
                System.out.println("invalid input");
                input.nextLine();
            }
        }
    }
}
