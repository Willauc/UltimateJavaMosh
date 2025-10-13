package TutorialWill;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class MortgageCalculator {

    public static double readNumber(String prompt, int min, int max) {
        double number;
        Scanner input = new Scanner(System.in);

        System.out.print(prompt);
        while (true) {
            number = input.nextDouble();
            if(number >= min &&  number <= max) {
                break;
            }
            System.out.print("Enter a number between " + min + " and " + max + ": ");
        }
        return number;
    }

    public static String calculatePayment(float mortgage, float rate, int term){
        final byte numberOfPaymentYear = 26;
        final byte percent = 100;

        float weeklyRate = rate / percent / numberOfPaymentYear;
        int termTotal = term * numberOfPaymentYear;

        Double payment = mortgage * ((weeklyRate * Math.pow((1 + weeklyRate), termTotal)) /
                (Math.pow((1 + weeklyRate), termTotal) - 1));

        return NumberFormat.getCurrencyInstance(Locale.CANADA).format(payment);
    }

    public static void calculate() {
        float mortgage =(float) readNumber("Enter Your Mortgage total: ", 100_000, 2_000_000);
        float rate = (float) readNumber("Enter Your Annual interest rate: ", 0, 10);
        int term = (int) readNumber("How long do you plant to pay : ", 5, 30);


        System.out.println("Your payment is " + calculatePayment(mortgage, rate, term) + " every two weeks.");
    }

    public static void calculateRest(final double principal, float annualRate) {
        final byte paimentInYear = 26;
        final byte percent = 100;
        Scanner input = new Scanner(System.in);

        double rate = annualRate / percent / paimentInYear;

        while (true) {
            System.out.print("Enter your biweekly payment amount: ");
            double payment = input.nextDouble();


            if (payment <= principal * rate) {
                System.out.println("Error: payment too small to cover interest.");
                return;
            }

            // Formule pour trouver le nombre de paiements restants :
            // n = ln(M / (M - P*r)) / ln(1 + r)
            double n = Math.log(payment / (payment - principal * rate)) / Math.log(1 + rate);

            double years = n / paimentInYear;

            System.out.printf("You have approximately %.0f payments left (%.1f years).%n", n, years);
        }
    }

}
