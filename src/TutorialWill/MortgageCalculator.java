package TutorialWill;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class MortgageCalculator {
    public static void calculate() {
        final byte weeksInYear = 26;
        final byte percent = 100;

        Scanner input = new Scanner(System.in);
        float mortgage;
        float rate;
        int howLong;

        System.out.print("Enter Your Mortgage total: ");
        while (true) {
            mortgage = input.nextFloat();
            if(mortgage >= 100_000 &&  mortgage <= 2_000_000) {
                break;
            }
            System.out.print("Enter Your Mortgage total (Between 100,000$  and 2,000,000$) : ");
        }

        System.out.print("Enter Your Annual interest rate: ");
        while (true) {
            rate = input.nextFloat();
            if(rate > 0 &&  rate <= 10) {
                break;
            }
            System.out.print("Enter Your Annual interest rate (Between 0%  and 10%) : ");
        }
        rate = rate / percent / weeksInYear;

        System.out.print("How long do you plant to pay : ");
        while (true) {
            howLong = input.nextInt();
            if(howLong >= 5 &&  howLong <= 30) {
                break;
            }
            System.out.print("How long do you plant to pay (Between 5y  and 30y) : ");
        }

        howLong = howLong * weeksInYear;

        Double payment = mortgage * ((rate * Math.pow((1 + rate), howLong)) /
                (Math.pow((1 + rate), howLong) - 1));

        String paymentFormater = NumberFormat.getCurrencyInstance(Locale.CANADA).format(payment);

        System.out.println("Your payment is " + paymentFormater + " every two weeks.");
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
