package TutorialWill;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class MortgageCalculator {
    final static byte numberOfPaymentYear = 26;
    final static byte percent = 100;

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

        getPayment(mortgage, rate, term);

        getPaymentSchedule(rate, term, mortgage);
    }

    private static void getPaymentSchedule(float rate, int term, float mortgage) {
        double biWeeklyRate = rate / percent / numberOfPaymentYear;
        int numberOfPayment = term * numberOfPaymentYear;

        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("_____________________________");

        for(int i = 1; i <= (term * numberOfPaymentYear); i++) {
            float balance =(float) (mortgage *
                            (Math.pow((1+biWeeklyRate), (numberOfPayment))-Math.pow((1+biWeeklyRate), i))/
                            (Math.pow((1+biWeeklyRate), (numberOfPayment)) - 1));
            System.out.println(NumberFormat.getCurrencyInstance(Locale.CANADA).format(balance));
        }
    }

    private static void getPayment(float mortgage, float rate, int term) {
        System.out.println("MORTGAGE");
        System.out.println("____________________");
        System.out.println("Biweekly payment: " + calculatePayment(mortgage, rate, term));
    }

    public static void calculateRest(final double principal, float annualRate) {
        Scanner input = new Scanner(System.in);

        double rate = annualRate / percent /    numberOfPaymentYear;

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

            double years = n / numberOfPaymentYear;

            System.out.printf("You have approximately %.0f payments left (%.1f years).%n", n, years);
        }
    }

}
