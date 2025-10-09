package TutorialWill;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class MortgageCalculator {
    public static void calculate() {
        final byte weeksInYear = 26;
        final byte percent = 100;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter Your Mortgage total: ");
        Float mortgage = input.nextFloat();

        System.out.print("Enter Your Annual interest rate: ");
        Float rate = input.nextFloat();
        rate = rate / percent / weeksInYear;

        System.out.print("How long do you plant to pay: ");
        int howLong = input.nextInt();
        howLong = howLong * weeksInYear;

        Double payment = mortgage * ((rate * Math.pow((1 + rate), howLong)) /
                (Math.pow((1 + rate), howLong) - 1));

        String paymentFormater = NumberFormat.getCurrencyInstance(Locale.CANADA).format(payment);

        System.out.println("Your payment is " + paymentFormater + " every two weeks.");
    }

    public static void calculateRest(final double principal, float annualRate) {
        final byte weeksInYear = 26;
        final byte percent = 100;
        Scanner input = new Scanner(System.in);

        // Taux par période (26 paiements par an)
        double rate = annualRate / percent / weeksInYear;

        while (true) {
            System.out.print("Enter your biweekly payment amount: ");
            double payment = input.nextDouble();


            // Vérification pour éviter division par zéro
            if (payment <= principal * rate) {
                System.out.println("Error: payment too small to cover interest.");
                return;
            }

            // Formule pour trouver le nombre de paiements restants :
            // n = ln(M / (M - P*r)) / ln(1 + r)
            double n = Math.log(payment / (payment - principal * rate)) / Math.log(1 + rate);

            // Conversion en années
            double years = n / 26;

            System.out.printf("You have approximately %.0f payments left (%.1f years).%n", n, years);
        }
    }

}
