package TutorialWill;

import java.util.Scanner;

public class Console {
    private static Scanner input = new Scanner(System.in);

    public static double readNumber(String prompt, int min, int max) {
        double number;

        System.out.print(prompt);
        while (true) {
            number = input.nextDouble();
            if (number >= min && number <= max) {
                break;
            }
            System.out.print("Enter a number between " + min + " and " + max + ": ");
        }
        return number;
    }

    public static double readNumber(String prompt) {
        System.out.println(prompt);
        return input.nextDouble();
    }
}
